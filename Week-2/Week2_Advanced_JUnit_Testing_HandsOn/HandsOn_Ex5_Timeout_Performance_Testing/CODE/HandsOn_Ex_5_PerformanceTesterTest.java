package com.sohin.junit;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTimeout;

public class HandsOn_Ex_5_PerformanceTesterTest {

    @Test
    void testPerformTaskCompletesInTime() {
        HandsOn_Ex_5_PerformanceTester tester = new HandsOn_Ex_5_PerformanceTester();

        assertTimeout(Duration.ofMillis(1000), tester::performTask);
    }
}
