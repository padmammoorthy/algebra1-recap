package com.algebra1recap.controller;

import com.algebra1recap.repository.UserRepository;
import com.algebra1recap.service.ParentDashboardService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/parent")
public class ParentController {

    private final ParentDashboardService parentDashboardService;
    private final UserRepository userRepository;

    public ParentController(ParentDashboardService parentDashboardService, UserRepository userRepository) {
        this.parentDashboardService = parentDashboardService;
        this.userRepository = userRepository;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model, Authentication authentication) {
        model.addAttribute("totalStudents", parentDashboardService.getTotalStudents());
        model.addAttribute("totalTestsTaken", parentDashboardService.getTotalTestsTaken());
        model.addAttribute("averageScore", parentDashboardService.getOverallAverageScore());
        model.addAttribute("passRate", parentDashboardService.getOverallPassRate());
        model.addAttribute("studentSummaries", parentDashboardService.getStudentSummaries());
        model.addAttribute("recentActivity", parentDashboardService.getRecentActivity(10));

        if (authentication != null) {
            userRepository.findByUsername(authentication.getName()).ifPresent(user -> {
                model.addAttribute("currentUser", user);
            });
        }
        return "parent-dashboard";
    }
}
