package com.example.flughafen.service;

import com.example.flughafen.foundation.Base58;
import com.example.flughafen.model.Country;
import com.example.flughafen.model.Flughafen;
import com.example.flughafen.model.Flugzeug;
import com.example.flughafen.persistence.FlughafenRepository;
import com.example.flughafen.persistence.FlugzeugRepository;
import com.example.flughafen.service.dtos.FlughafenDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.hibernate.Hibernate.map;

@RequiredArgsConstructor
@Service
@Transactional
public class FlugzeugService {

    private final FlugzeugRepository flugzeugRepository;

    private final Base58 base58;

    private Flugzeug fz1;
    private final FlughafenRepository flughafenRepository;


    public Optional<Flugzeug> findFlugzeugById(Long id) {

        return flugzeugRepository.findById(id);
    }

    public List<Flugzeug> getAllFlugzeug() {
        return flugzeugRepository.findAll();
    }



    public Flugzeug createFlugzeug(String flugzeugTyp,  int noOFPassengers, int fuelLitres, String flughafenName, String iso2Code, String countryName ) {


        Country austria = Country.builder().countryName(countryName).iso2Code(iso2Code).build();

        Flughafen fh1 = Flughafen.builder()
                .flughafenName(flughafenName)
                .country(austria)
                .build();

        Flugzeug f1 = Flugzeug.builder()
                .flugzeugType(flugzeugTyp)
                .fuelInLitres(fuelLitres)
                .currentFlughafen(fh1)
                .build();

        flugzeugRepository.save(f1);
        return f1;

    }

    public void updateFlugzeug(String flugzeugBezeichnung, int fuelInLitres, int numOfPassengers, Long id) {

        flugzeugRepository.findById(id).ifPresent(p -> {

            p.setFlugzeugType(flugzeugBezeichnung);
            p.setFuelInLitres(fuelInLitres);
            p.setNumberOfPassengers(numOfPassengers);
            p.setCurrentFlughafen(flughafenRepository.getReferenceById(id));

        });

    }

    public void deleteById(Long id) {

        flugzeugRepository.deleteById(id);
    }





}
