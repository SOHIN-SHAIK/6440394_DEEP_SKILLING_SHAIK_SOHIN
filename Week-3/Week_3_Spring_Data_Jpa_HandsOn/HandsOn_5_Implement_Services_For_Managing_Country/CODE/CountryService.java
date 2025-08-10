package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Country;
import java.util.List;

public interface CountryService {
    Country findCountryByCode(String code);
    Country addCountry(Country country);
    Country updateCountry(Country country);
    void deleteCountry(String code);
    List<Country> findCountriesByName(String partialName);
}
