package com.sohin.Week_2_Logging_Using_SLF4J;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample3 {
    private static final Logger logger = LoggerFactory.getLogger(LoggingExample3.class);

    public static void main(String[] args) {
        logger.info("Logging to both console and file");
        logger.warn("Warning log written to both destinations");
        logger.error("Error log goes to file and console");
    }
}
