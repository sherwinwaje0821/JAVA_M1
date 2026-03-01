package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;

@RestController
@RequestMapping("/api")
public class WelcomeController {

    @Value("${welcome.message}")
    private String welcomeMessage;

    @GetMapping("/welcome")
    public String showWelcomeMessage() {
        return welcomeMessage;
    }
}