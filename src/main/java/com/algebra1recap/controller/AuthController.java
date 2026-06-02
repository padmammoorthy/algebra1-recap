package com.algebra1recap.controller;

import com.algebra1recap.model.AppUser;
import com.algebra1recap.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/portal")
    public String portalSelect() {
        return "portal-select";
    }

    @GetMapping("/login/student")
    public String loginStudent() {
        return "login-student";
    }

    @GetMapping("/login/parent")
    public String loginParent() {
        return "login-parent";
    }

    @GetMapping("/signup")
    public String signupStudent() {
        return "signup";
    }

    @GetMapping("/signup/parent")
    public String signupParent() {
        return "signup-parent";
    }

    @PostMapping("/signup")
    public String createStudent(@RequestParam String username,
                                @RequestParam String password,
                                @RequestParam String displayName,
                                @RequestParam(required = false) String avatar,
                                @RequestParam(defaultValue = "emoji") String avatarType,
                                RedirectAttributes redirectAttributes) {
        if (userRepository.existsByUsernameAndRole(username, "PARENT")) {
            redirectAttributes.addFlashAttribute("error", "This username is already taken by a parent account.");
            return "redirect:/signup";
        }
        if (userRepository.existsByUsername(username)) {
            redirectAttributes.addFlashAttribute("error", "Username already taken.");
            return "redirect:/signup";
        }

        AppUser user = new AppUser(username, passwordEncoder.encode(password), displayName,
                avatar != null && !avatar.isEmpty() ? avatar : "📚", avatarType, "USER");
        userRepository.save(user);
        redirectAttributes.addFlashAttribute("success", "Account created! Please log in.");
        return "redirect:/login/student";
    }

    @PostMapping("/signup/parent")
    public String createParent(@RequestParam String username,
                               @RequestParam String password,
                               @RequestParam String displayName,
                               RedirectAttributes redirectAttributes) {
        if (userRepository.existsByUsernameAndRole(username, "USER")) {
            redirectAttributes.addFlashAttribute("error", "This username is already taken by a student account.");
            return "redirect:/signup/parent";
        }
        if (userRepository.existsByUsername(username)) {
            redirectAttributes.addFlashAttribute("error", "Username already taken.");
            return "redirect:/signup/parent";
        }

        AppUser user = new AppUser(username, passwordEncoder.encode(password), displayName,
                "👨‍👩‍👧", "emoji", "PARENT");
        userRepository.save(user);
        redirectAttributes.addFlashAttribute("success", "Parent account created! Please log in.");
        return "redirect:/login/parent";
    }
}
