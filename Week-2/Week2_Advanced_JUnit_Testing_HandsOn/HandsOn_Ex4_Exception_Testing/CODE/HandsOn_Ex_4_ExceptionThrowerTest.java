package com.sohin.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HandsOn_Ex_4_ExceptionThrowerTest {

    @Test
    void testThrowsException() {
        HandsOn_Ex_4_ExceptionThrower obj = new HandsOn_Ex_4_ExceptionThrower();

        assertThrows(IllegalArgumentException.class, () -> {
            obj.throwIfNegative(-5);
        });
    }

    @Test
    void testDoesNotThrow() {
        HandsOn_Ex_4_ExceptionThrower obj = new HandsOn_Ex_4_ExceptionThrower();

        assertDoesNotThrow(() -> {
            obj.throwIfNegative(10);
        });
    }
}
