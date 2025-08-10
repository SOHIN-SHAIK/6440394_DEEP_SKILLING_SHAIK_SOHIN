package com.sohin.Week_2_Logging_Using_SLF4J;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample2 {
    private static final Logger logger = LoggerFactory.getLogger(LoggingExample2.class);

    public static void main(String[] args) {
        String username = "Sohin";
        int userId = 101;

        logger.info("User {} with ID {} has logged in successfully", username, userId);
        logger.debug("Debugging session started for user: {}", username);
        logger.warn("User {} attempted restricted action", username);
    }
}
