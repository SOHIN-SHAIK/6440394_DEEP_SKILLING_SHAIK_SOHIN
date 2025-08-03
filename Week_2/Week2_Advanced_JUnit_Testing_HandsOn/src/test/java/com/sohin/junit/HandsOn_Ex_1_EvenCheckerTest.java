package com.sohin.junit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

public class HandsOn_Ex_1_EvenCheckerTest {
    HandsOn_Ex_1_EvenChecker checker = new HandsOn_Ex_1_EvenChecker();

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 10})
    void testIsEven_WithEvenNumbers(int number) {
        assertTrue(checker.isEven(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 9})
    void testIsEven_WithOddNumbers(int number) {
        assertFalse(checker.isEven(number));
    }
}
