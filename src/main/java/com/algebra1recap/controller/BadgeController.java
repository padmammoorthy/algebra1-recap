package com.algebra1recap.controller;

import com.algebra1recap.model.AppUser;
import com.algebra1recap.model.Badge;
import com.algebra1recap.repository.UserRepository;
import com.algebra1recap.service.BadgeService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@Controller
public class BadgeController {

    private final BadgeService badgeService;
    private final UserRepository userRepository;

    public BadgeController(BadgeService badgeService, UserRepository userRepository) {
        this.badgeService = badgeService;
        this.userRepository = userRepository;
    }

    @GetMapping("/badges")
    public String badges(Model model, Authentication authentication) {
        AppUser user = userRepository.findByUsername(authentication.getName()).orElseThrow();
        List<Badge> earnedBadges = badgeService.getUserBadges(user.getId());

        List<Map<String, String>> allBadges = getAllPossibleBadges();
        Set<String> earnedNames = new HashSet<>();
        for (Badge b : earnedBadges) {
            earnedNames.add(b.getBadgeName());
        }

        model.addAttribute("earnedBadges", earnedBadges);
        model.addAttribute("allBadges", allBadges);
        model.addAttribute("earnedNames", earnedNames);
        model.addAttribute("currentUser", user);
        return "badges";
    }

    private List<Map<String, String>> getAllPossibleBadges() {
        List<Map<String, String>> badges = new ArrayList<>();
        badges.add(badge("First Steps", "🌟", "Completed your first test!"));
        badges.add(badge("Quick Learner", "⚡", "Scored 80%+ on an easy test"));
        badges.add(badge("Math Warrior", "⚔️", "Scored 80%+ on a medium test"));
        badges.add(badge("Math Genius", "🧠", "Scored 80%+ on a hard test"));
        badges.add(badge("Perfect Score", "💯", "Achieved a perfect score!"));
        badges.add(badge("Hat Trick", "🎩", "Completed 3 tests"));
        badges.add(badge("Unstoppable", "🔥", "Completed 5 tests"));
        badges.add(badge("Dedicated Scholar", "📚", "Completed 10 tests"));
        badges.add(badge("Perfectionist", "⭐", "Got 3 perfect scores"));
        return badges;
    }

    private Map<String, String> badge(String name, String emoji, String description) {
        Map<String, String> b = new LinkedHashMap<>();
        b.put("name", name);
        b.put("emoji", emoji);
        b.put("description", description);
        return b;
    }
}
