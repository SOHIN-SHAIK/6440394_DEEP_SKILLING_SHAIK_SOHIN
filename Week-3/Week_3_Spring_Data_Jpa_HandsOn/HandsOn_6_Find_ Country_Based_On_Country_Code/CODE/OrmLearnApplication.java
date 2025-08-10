package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    public static void getAllCountriesTest(CountryService countryService) {
        System.out.println("Test started");
        try {
            Country country = countryService.findCountryByCode("IN");
            System.out.println("Country found: " + country);
        } catch (CountryNotFoundException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        System.out.println("Test ended");
    }

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        CountryService countryService = context.getBean(CountryService.class);
        getAllCountriesTest(countryService);  // <-- Make sure this is called here
    }
}
