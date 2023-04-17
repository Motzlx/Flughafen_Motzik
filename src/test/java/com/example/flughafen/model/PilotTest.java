package com.example.flughafen.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.PipedOutputStream;
import java.time.LocalDateTime;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;


public class PilotTest {

    @BeforeEach
    void setup() {

        Country austria = Country.builder().countryName("Austria").iso2Code("AT").build();
        Country germany = Country.builder().countryName("Germany").iso2Code("GER").build();


        Flugzeug fz1 = Flugzeug.builder()
                .id(1L)
                .currentFlughafen(null)
                .fuelInLitres(100)
                .flugzeugType("Boeing")
                .numberOfPassengers(100)
                .geflogeneFluege(null)
                .build();

        Flugzeug fz2 = Flugzeug.builder()
                .id(2L)
                .currentFlughafen(null)
                .fuelInLitres(100)
                .flugzeugType("Boeing")
                .numberOfPassengers(100)
                .geflogeneFluege(null)
                .build();




        Passagier pas1 = new Passagier("Huati","Markus","Flugner");
        Passagier pas2 = new Passagier("Huati1","Markus1","Flugner1");
        Passagier pas3 = new Passagier("Huati2","Markus2","Flugner2");
        Passagier pas4 = new Passagier("Huati3","Markus3","Flugner3");
        Passagier pas5 = new Passagier("Huati4","Markus4","Flugner4");



        Pilot c = new Pilot("Motzl","Matthias","Vityuk",100, LocalDateTime.now());


        Flughafen f1 = Flughafen.builder()
                .flughafenName("Schwechat")
                .country(austria)
                .id(1L)
                .build().addFlugzeuge(fz1,fz2);

        Flughafen f2 = Flughafen.builder()
                .flughafenName("Innsbruck")
                .country(null)
                .id(2L)
                .build();

        Flug flug1 = Flug.builder()
                .abflugZeit(LocalDateTime.now())
                .ankunftsZeit(LocalDateTime.MAX)
                .destinationFlughafen(f1)
                .sourceFlughafen(f2)
                .flugzeug(fz1)
                .build().addPassagiere(pas1,pas2,pas3,pas4,pas5);

        System.out.println(flug1);
        System.out.println(f2);
        System.out.println(f1);
        System.out.println(c);
        System.out.println(pas1);
        System.out.println(pas2);
        System.out.println(pas3);
        System.out.println(pas4);
        System.out.println(pas5);

    }

    @Test
    void ensureEsGeht() {



    }

}
