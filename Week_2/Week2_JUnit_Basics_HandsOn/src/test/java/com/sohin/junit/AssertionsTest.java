package com.sohin.junit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AssertionsTest {

    @Test
    void testAssertions() {
        // Equality check
        assertEquals(10, 5 + 5);

        // Boolean assertions
        assertTrue(5 < 10);
        assertFalse(10 < 5);

        // Null checks
        String str = null;
        assertNull(str);

        str = "JUnit";
        assertNotNull(str);
    }
}
