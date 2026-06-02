package com.algebra1recap.controller;

import com.algebra1recap.model.LessonContent;
import com.algebra1recap.repository.UserRepository;
import com.algebra1recap.service.LessonContentService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class LessonController {

    private final LessonContentService lessonContentService;
    private final UserRepository userRepository;

    public LessonController(LessonContentService lessonContentService, UserRepository userRepository) {
        this.lessonContentService = lessonContentService;
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/lessons";
    }

    @GetMapping("/lessons")
    public String lessonsList(Model model, Authentication authentication) {
        model.addAttribute("lessonsByChapter", lessonContentService.getLessonsByChapter());
        model.addAttribute("lessons", lessonContentService.getAllLessons());
        addUserAttributes(model, authentication);
        return "lessons";
    }

    @GetMapping("/lessons/{slug}")
    public String lessonDetail(@PathVariable String slug, Model model, Authentication authentication) {
        Optional<LessonContent> lesson = lessonContentService.getLessonBySlug(slug);
        if (lesson.isEmpty()) {
            return "redirect:/lessons";
        }
        model.addAttribute("lesson", lesson.get());
        model.addAttribute("lessonsByChapter", lessonContentService.getLessonsByChapter());
        addUserAttributes(model, authentication);
        return "lesson-detail";
    }

    private void addUserAttributes(Model model, Authentication authentication) {
        if (authentication != null) {
            userRepository.findByUsername(authentication.getName()).ifPresent(user -> {
                model.addAttribute("currentUser", user);
            });
        }
    }
}
