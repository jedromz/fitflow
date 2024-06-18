package com.fitflow.api.auth;

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
    public Map<String, Object> getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByUsername(authentication.getName()).orElseThrow();
        return Map.of(
                "id", user.getId(),
                "username", authentication.getName(),
                "roles", user.getRoles().stream().map(Role::getName).toList()
        );
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/success")
    public String success() {
        return "Success!";
    }
}
