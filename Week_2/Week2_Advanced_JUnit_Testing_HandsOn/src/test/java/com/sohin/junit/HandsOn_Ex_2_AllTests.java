package com.sohin.junit;

import org.junit.jupiter.api.Test;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Suite
@SelectClasses({
    HandsOn_Ex_1_EvenCheckerTest.class
})
public class HandsOn_Ex_2_AllTests {

    @Test
    void testSuiteIsRunning() {
        System.out.println("✅ Exercise 2 (Test Suite) is executing.");
        assertTrue(true);
    }
}
