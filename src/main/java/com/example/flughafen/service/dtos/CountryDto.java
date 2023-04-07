package com.example.flughafen.service.dtos;

import com.example.flughafen.model.Country;

public record CountryDto(
        String name,
        String iso2Code
) {
    public CountryDto(Country country) {
        this(country.getCountryName(), country.getIso2Code());
    }
}
