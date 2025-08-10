package com.sohin.spring.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CalculatorServiceTest {
    private final CalculatorService service = new CalculatorService();

    @Test
    void testAdd() {
        assertEquals(5, service.add(2, 3));
    }
}
