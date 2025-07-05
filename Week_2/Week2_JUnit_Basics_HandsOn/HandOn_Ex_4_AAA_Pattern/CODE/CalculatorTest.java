import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class Calculator {
    int add(int a, int b) {
        return a + b;
    }
}

public class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void setup() {
        // Arrange: Initialize before each test
        calculator = new Calculator();
    }

    @AfterEach
    void teardown() {
        // Cleanup after each test (optional)
        calculator = null;
    }

    @Test
    void testAdd() {
        // Act
        int result = calculator.add(2, 3);

        // Assert
        assertEquals(5, result);
    }
}
