package com.sohin.spring.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public int add(int a, int b) {
        return a + b;
    }

    // Optional: main method to test manually
    public static void main(String[] args) {
        CalculatorService service = new CalculatorService();
        int result = service.add(10, 5);
        System.out.println("Manual run result: " + result);
    }
}
