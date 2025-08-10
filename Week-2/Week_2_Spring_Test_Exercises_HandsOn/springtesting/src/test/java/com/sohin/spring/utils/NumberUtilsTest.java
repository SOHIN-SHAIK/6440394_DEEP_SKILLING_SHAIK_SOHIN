package com.sohin.spring.utils;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberUtilsTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 10})
    void testIsEvenWithEvenNumbers(int number) {
        System.out.println("Testing even number: " + number);
        assertTrue(NumberUtils.isEven(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 9})
    void testIsEvenWithOddNumbers(int number) {
        System.out.println("Testing odd number: " + number);
        assertFalse(NumberUtils.isEven(number));
    }
}
