package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.model.Country;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    @GetMapping("/country")
    public Country getCountryIndia() {
        Country country = new Country();
        country.setCode("IN");
        country.setName("India");
        return country;
    }

    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code) {
        Country country = new Country();
        country.setCode(code.toUpperCase());
        country.setName("Dummy Name"); // You can link this to real service later
        return country;
    }
}
