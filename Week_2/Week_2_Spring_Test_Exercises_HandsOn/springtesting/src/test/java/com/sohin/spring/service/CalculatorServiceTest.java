package com.sohin.spring.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    CalculatorService calculatorService = new CalculatorService();

    @Test
    void testAdd() {
        int result = calculatorService.add(10, 5);

        // Print result and path
        String projectPath = System.getProperty("user.dir");
        System.out.println("✅ Test Output: " + result);
        System.out.println("📁 Project Path: " + projectPath);

        assertEquals(15, result, "Addition should return 15");
    }

}
