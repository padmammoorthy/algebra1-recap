package com.algebra1recap.service;

import com.algebra1recap.model.*;
import com.algebra1recap.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ParentDashboardService {

    private final UserRepository userRepository;
    private final TestResultRepository testResultRepository;
    private final TestRepository testRepository;
    private final BadgeRepository badgeRepository;

    public ParentDashboardService(UserRepository userRepository, TestResultRepository testResultRepository, TestRepository testRepository, BadgeRepository badgeRepository) {
        this.userRepository = userRepository;
        this.testResultRepository = testResultRepository;
        this.testRepository = testRepository;
        this.badgeRepository = badgeRepository;
    }

    public long getTotalStudents() {
        return userRepository.findAll().stream().filter(u -> "USER".equals(u.getRole())).count();
    }

    public long getTotalTestsTaken() { return testResultRepository.count(); }

    public double getOverallAverageScore() {
        List<TestResult> all = testResultRepository.findAll();
        if (all.isEmpty()) return 0;
        return all.stream().mapToDouble(TestResult::getPercentage).average().orElse(0);
    }

    public double getOverallPassRate() {
        List<TestResult> all = testResultRepository.findAll();
        if (all.isEmpty()) return 0;
        long passed = all.stream().filter(r -> Boolean.TRUE.equals(r.getPassed())).count();
        return (passed * 100.0) / all.size();
    }

    public List<Map<String, Object>> getStudentSummaries() {
        List<AppUser> students = userRepository.findAll().stream().filter(u -> "USER".equals(u.getRole())).collect(Collectors.toList());
        List<Map<String, Object>> summaries = new ArrayList<>();
        for (AppUser student : students) {
            Map<String, Object> s = new LinkedHashMap<>();
            s.put("displayName", student.getDisplayName());
            s.put("username", student.getUsername());
            s.put("avatar", student.getAvatar());
            s.put("avatarType", student.getAvatarType());
            List<TestResult> results = testResultRepository.findByUserIdOrderByCompletedAtDesc(student.getId());
            s.put("testsCompleted", results.size());
            if (!results.isEmpty()) {
                double avg = results.stream().mapToDouble(TestResult::getPercentage).average().orElse(0);
                s.put("averageScore", Math.round(avg * 10.0) / 10.0);
                s.put("lastActivity", results.get(0).getCompletedAt());
            } else {
                s.put("averageScore", 0.0);
                s.put("lastActivity", null);
            }
            s.put("badgeCount", badgeRepository.findByUserIdOrderByEarnedAtDesc(student.getId()).size());
            summaries.add(s);
        }
        summaries.sort((a, b) -> {
            LocalDateTime aa = (LocalDateTime) a.get("lastActivity");
            LocalDateTime bb = (LocalDateTime) b.get("lastActivity");
            if (aa == null && bb == null) return 0;
            if (aa == null) return 1;
            if (bb == null) return -1;
            return bb.compareTo(aa);
        });
        return summaries;
    }

    public List<Map<String, Object>> getRecentActivity(int limit) {
        List<TestResult> recent = testResultRepository.findAll().stream()
                .sorted(Comparator.comparing(TestResult::getCompletedAt).reversed())
                .limit(limit).collect(Collectors.toList());
        List<Map<String, Object>> activities = new ArrayList<>();
        for (TestResult r : recent) {
            Map<String, Object> a = new LinkedHashMap<>();
            a.put("result", r);
            userRepository.findById(r.getUserId()).ifPresent(u -> {
                a.put("studentName", u.getDisplayName());
                a.put("avatar", u.getAvatar());
                a.put("avatarType", u.getAvatarType());
            });
            testRepository.findById(r.getTestId()).ifPresent(t -> {
                a.put("testName", t.getName());
                a.put("difficulty", t.getDifficulty().name());
            });
            activities.add(a);
        }
        return activities;
    }
}
