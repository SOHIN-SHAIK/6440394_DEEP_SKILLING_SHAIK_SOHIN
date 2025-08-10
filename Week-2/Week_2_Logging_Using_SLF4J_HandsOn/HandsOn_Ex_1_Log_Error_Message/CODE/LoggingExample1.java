package com.sohin.Week_2_Logging_Using_SLF4J;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample1 {
    private static final Logger logger = LoggerFactory.getLogger(LoggingExample1.class);

    public static void main(String[] args) {
        logger.error("This is an error message");
        logger.warn("This is a warning message");
    }
}
