package com.algebra1recap.service;

import com.algebra1recap.model.*;
import com.algebra1recap.repository.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BadgeService {

    private final BadgeRepository badgeRepository;
    private final TestResultRepository testResultRepository;
    private final TestRepository testRepository;

    public BadgeService(BadgeRepository badgeRepository, TestResultRepository testResultRepository, TestRepository testRepository) {
        this.badgeRepository = badgeRepository;
        this.testResultRepository = testResultRepository;
        this.testRepository = testRepository;
    }

    public List<Badge> getUserBadges(Long userId) {
        return badgeRepository.findByUserIdOrderByEarnedAtDesc(userId);
    }

    public List<Badge> checkAndAwardBadges(Long userId, TestResult result) {
        List<Badge> newBadges = new ArrayList<>();
        List<TestResult> allResults = testResultRepository.findByUserId(userId);
        Test test = testRepository.findById(result.getTestId()).orElse(null);

        if (allResults.size() == 1) {
            awardIfNew(userId, "First Steps", "\uD83C\uDF1F", "Completed your first test!", newBadges);
        }
        if (test != null && test.getDifficulty() == Test.Difficulty.EASY && result.getPercentage() >= 80) {
            awardIfNew(userId, "Quick Learner", "\u26A1", "Scored 80%+ on an easy test", newBadges);
        }
        if (test != null && test.getDifficulty() == Test.Difficulty.MEDIUM && result.getPercentage() >= 80) {
            awardIfNew(userId, "Math Warrior", "\u2694\uFE0F", "Scored 80%+ on a medium test", newBadges);
        }
        if (test != null && test.getDifficulty() == Test.Difficulty.HARD && result.getPercentage() >= 80) {
            awardIfNew(userId, "Math Genius", "\uD83E\uDDE0", "Scored 80%+ on a hard test", newBadges);
        }
        if (result.getPercentage() == 100) {
            awardIfNew(userId, "Perfect Score", "\uD83D\uDCAF", "Achieved a perfect score!", newBadges);
        }
        if (allResults.size() >= 3) {
            awardIfNew(userId, "Hat Trick", "\uD83C\uDFA9", "Completed 3 tests", newBadges);
        }
        if (allResults.size() >= 5) {
            awardIfNew(userId, "Unstoppable", "\uD83D\uDD25", "Completed 5 tests", newBadges);
        }
        if (allResults.size() >= 10) {
            awardIfNew(userId, "Dedicated Scholar", "\uD83D\uDCDA", "Completed 10 tests", newBadges);
        }
        long perfectCount = allResults.stream().filter(r -> r.getPercentage() == 100).count();
        if (perfectCount >= 3) {
            awardIfNew(userId, "Perfectionist", "\u2B50", "Got 3 perfect scores", newBadges);
        }

        return newBadges;
    }

    private void awardIfNew(Long userId, String name, String emoji, String desc, List<Badge> list) {
        if (!badgeRepository.existsByUserIdAndBadgeName(userId, name)) {
            Badge badge = new Badge(userId, name, emoji, desc);
            badgeRepository.save(badge);
            list.add(badge);
        }
    }
}
