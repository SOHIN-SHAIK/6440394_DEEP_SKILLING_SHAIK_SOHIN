package com.sohin.junit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsTest {
    
    @Test
    void testAdd() {
        MathUtils math = new MathUtils();
        assertEquals(9, math.add(4, 5));
    }

    @Test
    void testMultiply() {
        MathUtils math = new MathUtils();
        assertEquals(12, math.multiply(3, 4));
    }
}
