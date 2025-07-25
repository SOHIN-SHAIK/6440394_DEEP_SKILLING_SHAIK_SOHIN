package com.cognizant.ormlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/")
    public String home() {
        LOGGER.info("Home endpoint accessed - Country HandsOn running");
        System.out.println("Home endpoint accessed - Country HandsOn running");
        return "App is running: Country HandsOn";
    }
}
