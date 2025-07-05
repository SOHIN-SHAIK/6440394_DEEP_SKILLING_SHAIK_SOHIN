package com.sohin.junit;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HandsOn_Ex_3_OrderedTests {

    @Test
    @Order(2)
    void secondTest() {
        System.out.println("🔹 Executing Test 2");
        Assertions.assertTrue(true);
    }

    @Test
    @Order(1)
    void firstTest() {
        System.out.println("🔹 Executing Test 1");
        Assertions.assertTrue(true);
    }

    @Test
    @Order(3)
    void thirdTest() {
        System.out.println("🔹 Executing Test 3");
        Assertions.assertTrue(true);
    }
}
