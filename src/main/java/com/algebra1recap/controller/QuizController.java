package com.algebra1recap.controller;

import com.algebra1recap.dto.AnswerResult;
import com.algebra1recap.model.Question;
import com.algebra1recap.repository.UserRepository;
import com.algebra1recap.service.QuizService;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class QuizController {

    private final QuizService quizService;
    private final UserRepository userRepository;

    public QuizController(QuizService quizService, UserRepository userRepository) {
        this.quizService = quizService;
        this.userRepository = userRepository;
    }

    @GetMapping("/quiz")
    public String quiz(@RequestParam(defaultValue = "0") int page, Model model, Authentication authentication) {
        Page<Question> questionsPage = quizService.getQuestionsPage(page);
        model.addAttribute("questions", questionsPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", questionsPage.getTotalPages());
        model.addAttribute("totalQuestions", questionsPage.getTotalElements());
        addUserAttributes(model, authentication);
        return "quiz";
    }

    @PostMapping("/answer")
    @ResponseBody
    public AnswerResult checkAnswer(@RequestParam Long questionId, @RequestParam String selectedAnswer) {
        return quizService.checkAnswer(questionId, selectedAnswer);
    }

    private void addUserAttributes(Model model, Authentication authentication) {
        if (authentication != null) {
            userRepository.findByUsername(authentication.getName()).ifPresent(user -> {
                model.addAttribute("currentUser", user);
            });
        }
    }
}
