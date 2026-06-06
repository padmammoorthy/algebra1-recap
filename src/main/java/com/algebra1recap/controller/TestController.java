package com.algebra1recap.controller;

import com.algebra1recap.model.*;
import com.algebra1recap.repository.UserRepository;
import com.algebra1recap.service.BadgeService;
import com.algebra1recap.service.TestService;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class TestController {

    private final TestService testService;
    private final BadgeService badgeService;
    private final UserRepository userRepository;

    public TestController(TestService testService, BadgeService badgeService, UserRepository userRepository) {
        this.testService = testService;
        this.badgeService = badgeService;
        this.userRepository = userRepository;
    }

    @GetMapping("/tests")
    public String listTests(Model model, Authentication authentication) {
        List<Test> allTests = testService.getAllTests().stream()
                .filter(t -> !"olympiad".equals(t.getCategory()))
                .collect(Collectors.toList());
        Map<String, List<Test>> testsByDifficulty = allTests.stream()
                .collect(Collectors.groupingBy(t -> t.getDifficulty().name(),
                        LinkedHashMap::new, Collectors.toList()));
        model.addAttribute("testsByDifficulty", testsByDifficulty);
        addUserAttributes(model, authentication);
        return "tests";
    }

    @GetMapping("/olympiad")
    public String listOlympiad(Model model, Authentication authentication) {
        List<Test> olympiadTests = testService.getTestsByCategory("olympiad");
        model.addAttribute("olympiadTests", olympiadTests);
        addUserAttributes(model, authentication);
        return "olympiad";
    }

    @GetMapping("/tests/{id}")
    public String takeTest(@PathVariable Long id,
                           @RequestParam(defaultValue = "0") int page,
                           Model model, Authentication authentication) {
        Optional<Test> testOpt = testService.getTestById(id);
        if (testOpt.isEmpty()) {
            return "redirect:/tests";
        }
        Test test = testOpt.get();
        Page<TestQuestion> questionsPage = testService.getTestQuestionsPage(id, page);

        model.addAttribute("test", test);
        model.addAttribute("questions", questionsPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", testService.getTotalPages(id));
        model.addAttribute("totalQuestions", testService.getQuestionCount(id));
        addUserAttributes(model, authentication);
        return "take-test";
    }

    @PostMapping("/tests/{id}/save-answers")
    public String saveAnswers(@PathVariable Long id,
                              @RequestParam Map<String, String> allParams,
                              Authentication authentication) {
        AppUser user = userRepository.findByUsername(authentication.getName()).orElseThrow();
        Map<Long, String> answers = new HashMap<>();
        for (Map.Entry<String, String> entry : allParams.entrySet()) {
            if (entry.getKey().startsWith("answer_")) {
                Long questionId = Long.parseLong(entry.getKey().replace("answer_", ""));
                answers.put(questionId, entry.getValue());
            }
        }
        TestResult result = testService.gradeAndSaveTest(user.getId(), id, answers);
        badgeService.checkAndAwardBadges(user.getId(), result);
        return "redirect:/tests/" + id + "/result?resultId=" + result.getId();
    }

    @GetMapping("/tests/{id}/result")
    public String testResult(@PathVariable Long id,
                             @RequestParam(required = false) Long resultId,
                             Model model, Authentication authentication) {
        AppUser user = userRepository.findByUsername(authentication.getName()).orElseThrow();
        Optional<Test> testOpt = testService.getTestById(id);
        if (testOpt.isEmpty()) {
            return "redirect:/tests";
        }

        Test test = testOpt.get();
        List<TestQuestion> questions = testService.getAllTestQuestions(id);
        List<Badge> userBadges = badgeService.getUserBadges(user.getId());

        // Get the result for score display
        TestResult result = null;
        if (resultId != null) {
            result = testService.getTestResultById(resultId).orElse(null);
        }

        // Get only incorrect questions if result exists
        List<TestQuestion> incorrectQuestions = questions;
        if (result != null) {
            Map<Long, String> userAnswers = testService.getUserAnswers(resultId);
            incorrectQuestions = questions.stream()
                    .filter(q -> {
                        String userAnswer = userAnswers.get(q.getId());
                        return userAnswer == null || !userAnswer.equalsIgnoreCase(q.getCorrectAnswer());
                    })
                    .collect(Collectors.toList());
            model.addAttribute("userAnswers", userAnswers);
        }

        model.addAttribute("test", test);
        model.addAttribute("questions", incorrectQuestions);
        model.addAttribute("allQuestions", questions);
        model.addAttribute("result", result);
        model.addAttribute("badges", userBadges);
        addUserAttributes(model, authentication);
        return "test-result";
    }

    private void addUserAttributes(Model model, Authentication authentication) {
        if (authentication != null) {
            userRepository.findByUsername(authentication.getName()).ifPresent(user -> {
                model.addAttribute("currentUser", user);
            });
        }
    }
}
