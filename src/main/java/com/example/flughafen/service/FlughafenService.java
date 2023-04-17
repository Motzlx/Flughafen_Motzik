package com.example.flughafen.service;

import com.example.flughafen.foundation.Base58;
import com.example.flughafen.model.Country;
import com.example.flughafen.model.Flughafen;
import com.example.flughafen.model.Flugzeug;
import com.example.flughafen.persistence.FlughafenRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.hibernate.Hibernate.map;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional

public class FlughafenService {

    private final FlughafenRepository flughafenRepository;

    private final Base58 base58;

    private Flughafen f1;

    @Transactional
    public Flughafen createFlughafen(String flugzeugName, String iso2Code, String countryName) {

        f1 = Flughafen.builder()

                .flughafenName(flugzeugName)
                .country(Country.builder().iso2Code(iso2Code).countryName(countryName).build())
                .build();
        flughafenRepository.save(f1);

        return f1;
    }

    public List<Flughafen> getAllFlugenhafen() {
        return flughafenRepository.findAll();
    }

    public Flughafen getById(Long id) {
        return flughafenRepository.getById(id);
    }







}
