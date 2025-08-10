package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;
import jakarta.transaction.Transactional; // or org.springframework.transaction.annotation.Transactional
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    @Transactional
    public Country addCountry(Country country) {
        return countryRepository.save(country);
    }

    @Override
    @Transactional
    public Country findCountryByCode(String countryCode) throws CountryNotFoundException {
        return countryRepository.findById(countryCode)
            .orElseThrow(() -> new CountryNotFoundException("Country not found for code: " + countryCode));
    }
}
