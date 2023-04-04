package com.example.flughafen.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data

public class Pilot extends AbstractPerson {

    private Integer noOfFlights;

    private LocalDateTime yearOfGraduation;


    @Builder
    public Pilot(String userName, String firstName, String lastName, Integer noOfFlights, LocalDateTime yearOfGraduation) {
        super(userName, firstName, lastName);
        this.noOfFlights = noOfFlights;
        this.yearOfGraduation = yearOfGraduation;
    }
}
