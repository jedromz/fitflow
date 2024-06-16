package com.fitflow.api.auth;

import lombok.Getter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/me")
    public String me() {
        return "Hello, World!";
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/success")
    public String success() {
        return "Success!";
    }
}
