package com.algebra1recap.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Set;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/portal", "/login", "/login/**", "/signup", "/signup/**", "/css/**", "/images/**", "/h2-console/**").permitAll()
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/parent/**").hasRole("PARENT")
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/portal")
                .loginProcessingUrl("/login")
                .successHandler(roleBasedSuccessHandler())
                .failureHandler((request, response, exception) -> {
                    String portal = request.getParameter("portal");
                    if ("parent".equals(portal)) {
                        response.sendRedirect("/login/parent?error");
                    } else if ("student".equals(portal)) {
                        response.sendRedirect("/login/student?error");
                    } else {
                        response.sendRedirect("/portal?error");
                    }
                })
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/portal")
                .logoutRequestMatcher(new org.springframework.security.web.util.matcher.AntPathRequestMatcher("/logout", "GET"))
                .permitAll()
            )
            .csrf(csrf -> csrf
                .ignoringRequestMatchers("/h2-console/**", "/answer", "/tests/*/save-answers", "/logout")
            )
            .headers(headers -> headers
                .frameOptions(frame -> frame.sameOrigin())
            );

        return http.build();
    }

    @Bean
    public AuthenticationSuccessHandler roleBasedSuccessHandler() {
        return (HttpServletRequest request, HttpServletResponse response, Authentication authentication) -> {
            Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
            String portal = request.getParameter("portal");

            if ("parent".equals(portal) && !roles.contains("ROLE_PARENT")) {
                request.getSession().invalidate();
                response.sendRedirect("/login/parent?roleError");
                return;
            }
            if ("student".equals(portal) && roles.contains("ROLE_PARENT")) {
                request.getSession().invalidate();
                response.sendRedirect("/login/student?roleError");
                return;
            }

            if (roles.contains("ROLE_ADMIN")) {
                response.sendRedirect("/admin");
            } else if (roles.contains("ROLE_PARENT")) {
                response.sendRedirect("/parent/dashboard");
            } else {
                response.sendRedirect("/lessons");
            }
        };
    }
}
