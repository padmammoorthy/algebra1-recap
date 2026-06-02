package com.algebra1recap.service;

import com.algebra1recap.model.*;
import com.algebra1recap.repository.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TestService {

    private static final int QUESTIONS_PER_PAGE = 5;
    private final TestRepository testRepository;
    private final TestQuestionRepository testQuestionRepository;
    private final TestResultRepository testResultRepository;

    public TestService(TestRepository testRepository, TestQuestionRepository testQuestionRepository, TestResultRepository testResultRepository) {
        this.testRepository = testRepository;
        this.testQuestionRepository = testQuestionRepository;
        this.testResultRepository = testResultRepository;
    }

    public List<Test> getAllTests() { return testRepository.findAll(); }
    public Optional<Test> getTestById(Long id) { return testRepository.findById(id); }
    public List<Test> getTestsByCategory(String category) { return testRepository.findByCategory(category); }

    public Page<TestQuestion> getTestQuestionsPage(Long testId, int page) {
        return testQuestionRepository.findByTestIdOrderByIdAsc(testId, PageRequest.of(page, QUESTIONS_PER_PAGE));
    }

    public List<TestQuestion> getAllTestQuestions(Long testId) {
        return testQuestionRepository.findByTestIdOrderByIdAsc(testId);
    }

    public long getQuestionCount(Long testId) { return testQuestionRepository.countByTestId(testId); }

    public int getTotalPages(Long testId) {
        long count = getQuestionCount(testId);
        return (int) Math.ceil((double) count / QUESTIONS_PER_PAGE);
    }

    public TestResult gradeAndSaveTest(Long userId, Long testId, Map<Long, String> answers) {
        List<TestQuestion> questions = getAllTestQuestions(testId);
        int score = 0;
        for (TestQuestion question : questions) {
            String userAnswer = answers.get(question.getId());
            if (userAnswer != null && userAnswer.equalsIgnoreCase(question.getCorrectAnswer())) {
                score++;
            }
        }
        int totalQuestions = questions.size();
        boolean passed = totalQuestions > 0 && ((double) score / totalQuestions) >= 0.7;
        TestResult result = new TestResult(userId, testId, score, totalQuestions, passed);
        return testResultRepository.save(result);
    }
}
