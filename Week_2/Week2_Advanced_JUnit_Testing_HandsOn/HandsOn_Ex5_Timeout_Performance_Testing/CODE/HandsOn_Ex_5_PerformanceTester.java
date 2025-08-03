package com.sohin.junit;

public class HandsOn_Ex_5_PerformanceTester {
    public void performTask() {
        // Simulate a task with sleep (e.g., database query, processing)
        try {
            Thread.sleep(500); // 500ms delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
