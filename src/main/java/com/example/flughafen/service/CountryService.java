package com.example.flughafen.service;

import com.example.flughafen.foundation.Base58;
import com.example.flughafen.model.Country;
import com.example.flughafen.persistence.CountryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class CountryService {

    private final CountryRepository countryRepository;

    private final Base58 base58;

    @Transactional
    public Country createCountry(String name, String iso2Code) {

        Country c1 = Country.builder()
                .countryName(name)
                .iso2Code(iso2Code)
                .build();

        countryRepository.save(c1);
        return c1;

    }

    public List<Country> getAllCountries () { return  countryRepository.findAll(); }




}
