package com.algebra1recap.config;

import com.algebra1recap.model.AppUser;
import com.algebra1recap.repository.UserRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Tracks last activity for any authenticated user on every request.
 * This ensures the parent dashboard always shows accurate "last activity" 
 * regardless of whether the student used practice tests, formal tests, lessons, etc.
 */
@Component
public class ActivityTrackingFilter implements Filter {

    private final UserRepository userRepository;

    public ActivityTrackingFilter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpReq = (HttpServletRequest) request;
        String path = httpReq.getRequestURI();

        // Only track activity on learning pages: lessons, practice quiz, tests, olympiad
        if (path.startsWith("/lessons") || path.startsWith("/quiz") || path.startsWith("/answer")
                || path.startsWith("/tests") || path.startsWith("/olympiad")) {

            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (auth != null && auth.isAuthenticated() && !"anonymousUser".equals(auth.getPrincipal())) {
                userRepository.findByUsername(auth.getName()).ifPresent(user -> {
                    user.setLastActiveAt(LocalDateTime.now());
                    userRepository.save(user);
                });
            }
        }

        chain.doFilter(request, response);
    }
}
