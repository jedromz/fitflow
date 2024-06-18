package com.fitflow.api.auth;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @GetMapping("/me")
    public Map<String, Object> getCurrentUser(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByUsername(authentication.getName()).orElseThrow();

        // Retrieve the JSESSIONID cookie from the request
        Cookie[] cookies = request.getCookies();
        String sessionId = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("JSESSIONID".equals(cookie.getName())) {
                    sessionId = cookie.getValue();
                    response.addHeader("Set-Cookie", "JSESSIONID=" + sessionId + "; Path=/; HttpOnly; SameSite=Lax");
                }
            }
        }

        return Map.of(
                "id", user.getId(),
                "username", authentication.getName(),
                "roles", user.getRoles().stream().map(Role::getName).toList(),
                "sessionId", sessionId  // Include the sessionId in the response body
        );
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/success")
    public String success() {
        return "Success!";
    }
}
