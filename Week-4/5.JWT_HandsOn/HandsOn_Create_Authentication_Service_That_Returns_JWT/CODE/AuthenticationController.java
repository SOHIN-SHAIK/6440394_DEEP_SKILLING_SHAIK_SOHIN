package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.util.JwtUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Base64;

@RestController
public class AuthenticationController {

    @GetMapping("/authenticate")
    public String authenticate(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Basic ")) {
            String base64Credentials = authHeader.substring("Basic ".length());
            String credentials = new String(Base64.getDecoder().decode(base64Credentials));
            String username = credentials.split(":")[0];
            String token = JwtUtil.generateToken(username);
            return "{\"token\":\"" + token + "\"}";
        } else {
            throw new RuntimeException("Missing or invalid Authorization header");
        }
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello from Auth Controller!";
    }
}
