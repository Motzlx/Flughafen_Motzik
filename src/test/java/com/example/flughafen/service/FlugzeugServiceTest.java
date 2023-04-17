package com.example.flughafen.service;

import com.example.flughafen.foundation.Base58;
import com.example.flughafen.model.Country;
import com.example.flughafen.model.Flughafen;
import com.example.flughafen.model.Flugzeug;
import com.example.flughafen.persistence.FlughafenRepository;
import com.example.flughafen.persistence.FlugzeugRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.AdditionalAnswers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assumptions.assumeThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FlugzeugServiceTest {


    private @Mock FlugzeugRepository flugzeugRepository;

    private @Mock FlughafenRepository flughafenRepository;

    private FlugzeugService flugzeugService;



    @BeforeEach
    void setup() {
        assumeThat(flughafenRepository).isNotNull();
        assumeThat(flugzeugRepository).isNotNull();
        flugzeugService = new FlugzeugService(flugzeugRepository,new Base58(), flughafenRepository);

    }


    @Test
    void ensureEverythingWorksCorrectlyLol() {
        //given
        String flughafenName = "Schwechat";

        String flugzeugTyp = "Bong";
        int numOfPassangers = 100;
        int fuelInLitre = 100;

        String countryName = "Austria";
        String iso2Code = "AT";

        Country austria = Country.builder()

                .iso2Code(iso2Code)
                .countryName(countryName)
                .build();

        Flugzeug fz1 = Flugzeug.builder()
                .flugzeugType(flugzeugTyp)
                .id(1L)
                .numberOfPassengers(numOfPassangers)
                .fuelInLitres(fuelInLitre)
                .build();

        Flughafen fh1 = Flughafen.builder()
                .id(1L)
                .country(austria)
                .flughafenName(flughafenName)
                .build();

        //train mocks

        when(flughafenRepository.findById(1L)).thenReturn(Optional.of(fh1));
        when(flugzeugRepository.save(any())).then(AdditionalAnswers.returnsFirstArg());

        //when

        var flugzeug = flugzeugService.createFlugzeug(flugzeugTyp,numOfPassangers,fuelInLitre,flughafenName,iso2Code,countryName);

        //then
        assertThat(flugzeug).isNotNull();
        assertThat(flugzeug.getFlugzeugType()).isEqualTo(flugzeugTyp);

    }

}
