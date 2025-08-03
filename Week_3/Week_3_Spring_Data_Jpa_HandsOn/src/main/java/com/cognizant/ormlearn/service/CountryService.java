package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

public interface CountryService {
    Country addCountry(Country country);
    
    Country findCountryByCode(String countryCode) throws CountryNotFoundException;
    
    // Add other methods if needed
}
