package com.example.flughafen.service;

import com.example.flughafen.foundation.Base58;
import com.example.flughafen.model.Flughafen;
import com.example.flughafen.persistence.FlughafenRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Transactional

public class FlughafenService {

    private final FlughafenRepository flughafenRepository;

    private final Base58 base58;


    public Flughafen createFlughafen() {

        Flughafen.builder()
                .flugzeuge()
                .flughafenName()
                .country()
                .
    }




}
