package com.example.flughafen.persistence;

import com.example.flughafen.model.Country;
import com.example.flughafen.model.Flug;
import com.example.flughafen.model.Flughafen;
import com.example.flughafen.model.Flugzeug;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assumptions.assumeThat;
import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;


@Slf4j
@DataJpaTest
class FlugzeugRepositoryTest {

    @Autowired
    private FlugzeugRepository flugzeugRepository;

    private Flugzeug f1;
    private Flugzeug f2;
    private Flugzeug f3;

    private Flug flug;

    private List<Flug> fluege = new ArrayList<>();

    private Flughafen schwechat;

    private Flughafen newYork;

    private Country austria;

    public FlugzeugRepositoryTest() {
    }

    @BeforeEach
    void setup() {

        assumeThat(flugzeugRepository).isNotNull();




        schwechat.builder()
                .flughafenName("Schwechat")
                .country(austria)
                .build();

        newYork.builder()
                .country(austria)
                .flughafenName("Kenn i di")
                .flugzeuge(null)
                .build();

        austria = Country.builder()

                .iso2Code("Deutschland")
                .countryName("DE")
                .build();

        flug.builder()
                .flugzeug(f1)
                .abflugZeit(LocalDateTime.now())
                .ankunftsZeit(LocalDateTime.now())
                .passagierList(null)
                .sourceFlughafen(schwechat)
                .destinationFlughafen(null)
                .build();

        f1.builder()
                .flugzeugType("Boeing")
                .fuelInLitres(100)
                .geflogeneFluege(fluege)
                .currentFlughafen(schwechat)
                .numberOfPassengers(500)
                .build();

        fluege.add(flug);

        System.out.println(f1);
        System.out.println(schwechat);
        System.out.println(newYork);
        System.out.println(fluege);
        System.out.println(flug);

    }

    @Test
    void testitest() {


    }





}
