package com.cognizant.spring_learn.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping(value = "/hello", method = {RequestMethod.GET, RequestMethod.POST})
    public String sayHello() {
        return "Application is working!";
    }
}
