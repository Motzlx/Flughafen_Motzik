package com.example.flughafen.service.dtos;

import com.example.flughafen.model.Flughafen;

public record FlughafenDto (String flughafenName,  CountryDto countryDto) {

    public FlughafenDto (Flughafen flughafen) {
        this(flughafen.getFlughafenName(),
                new CountryDto(flughafen.getCountry()));

    }
}
