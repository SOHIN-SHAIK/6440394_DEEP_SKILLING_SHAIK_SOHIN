package com.sohin.junit;

public class HandsOn_Ex_4_ExceptionThrower {
    public void throwIfNegative(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Negative numbers not allowed");
        }
    }
}
