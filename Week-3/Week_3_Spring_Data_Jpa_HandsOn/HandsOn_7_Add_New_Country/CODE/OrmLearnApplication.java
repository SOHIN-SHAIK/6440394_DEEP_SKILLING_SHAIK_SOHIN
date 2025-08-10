package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

    @Autowired
    private CountryService countryService;

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        testAddCountry();
        testFindCountryByCode();
    }

    private void testAddCountry() {
        Country country = new Country("IN", "India");
        countryService.addCountry(country);
        System.out.println("Country added: " + country.getCode() + " - " + country.getName());
    }

    private void testFindCountryByCode() {
        try {
            Country country = countryService.findCountryByCode("IN");
            System.out.println("Country found: " + country.getCode() + " - " + country.getName());
        } catch (Exception e) {
            System.out.println("Country not found.");
        }
    }
}
