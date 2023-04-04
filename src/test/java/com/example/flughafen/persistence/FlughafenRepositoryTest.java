package com.example.flughafen.persistence;

import com.example.flughafen.model.Country;
import com.example.flughafen.model.Flughafen;
import com.example.flughafen.model.Flugzeug;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import com.example.flughafen.persistence.FlughafenRepository;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assumptions.assumeThat;

@Slf4j
@DataJpaTest

class FlughafenRepositoryTest {


    @Autowired
    private FlughafenRepository flughafenRepository;

    private Flughafen schwechat;

    private Flugzeug f1;
    private Flugzeug f2;
    private Flugzeug f3;

    private Country austria;




    @BeforeEach
    void setup() {
        assumeThat(flughafenRepository).isNotNull();



        austria = Country.builder()

                .iso2Code("Deutschland")
                .countryName("DE")
                .build();

        schwechat = Flughafen.builder()

                .flughafenName("Schwechat")
                .country(austria)
                .build();


        f1 = Flugzeug.builder()

                .currentFlughafen(schwechat)
                .flugzeugType("Boeing")
                .fuelInLitres(100)
                .build();


        f2 = Flugzeug.builder()

                .currentFlughafen(schwechat)
                .flugzeugType("Boeing")
                .fuelInLitres(100)
                .build();

        f3 = Flugzeug.builder()

                .currentFlughafen(schwechat)
                .flugzeugType("Boeing")
                .fuelInLitres(100)
                .build();



        schwechat.addFlugzeuge(f1,f2,f3);
               flughafenRepository.save(schwechat);


        //then assert

        var saved = flughafenRepository.save(schwechat);
        assertThat(saved).isEqualTo(schwechat);
       assertThat(saved.getId()).isNotNull();
       List.of(f1,f2,f3).forEach(flugzeug -> {
           assertThat(flugzeug.getId()).isNotNull();
       });

        assertThat(schwechat.getId()).isNotNull();
        assertThat(austria.getId()).isNotNull();


    }

    @Test
    void ensureSaveWorks() {

        System.out.println(f1);
        System.out.println(f2);
        System.out.println(f3);
        System.out.println(f1.getId());
        System.out.println(schwechat);
        System.out.println(schwechat.getId());
        System.out.println(austria);


    }

}
