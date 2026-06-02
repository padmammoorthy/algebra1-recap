package com.algebra1recap.service;

import com.algebra1recap.dto.AnswerResult;
import com.algebra1recap.model.Question;
import com.algebra1recap.repository.QuestionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class QuizService {

    private static final int PAGE_SIZE = 5;
    private final QuestionRepository questionRepository;

    public QuizService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Page<Question> getQuestionsPage(int page) {
        return questionRepository.findAllByOrderByLessonNumberAscIdAsc(PageRequest.of(page, PAGE_SIZE));
    }

    public AnswerResult checkAnswer(Long questionId, String selectedAnswer) {
        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new RuntimeException("Question not found: " + questionId));
        boolean correct = question.getCorrectAnswer().equalsIgnoreCase(selectedAnswer);
        return new AnswerResult(questionId, selectedAnswer, question.getCorrectAnswer(), correct, correct ? null : question.getHint());
    }
}
