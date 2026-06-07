package com.algebra1recap.config;

import com.algebra1recap.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Tracks last activity for authenticated users when they access learning pages.
 * Extends OncePerRequestFilter to run AFTER Spring Security populates the SecurityContext.
 */
@Component
public class ActivityTrackingFilter extends OncePerRequestFilter {

    private final UserRepository userRepository;

    public ActivityTrackingFilter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // Process the request first (so Spring Security sets up auth context)
        filterChain.doFilter(request, response);

        // Then track activity after the request is processed
        String path = request.getRequestURI();

        if (path.startsWith("/lessons") || path.startsWith("/quiz") || path.startsWith("/answer")
                || path.startsWith("/tests") || path.startsWith("/olympiad")) {

            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (auth != null && auth.isAuthenticated() && !"anonymousUser".equals(auth.getPrincipal())) {
                try {
                    userRepository.findByUsername(auth.getName()).ifPresent(user -> {
                        user.setLastActiveAt(LocalDateTime.now());
                        userRepository.save(user);
                    });
                } catch (Exception e) {
                    // Don't let activity tracking break the request
                }
            }
        }
    }
}
