package com.example.flughafen.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name="Country")

public class Country extends AbstractPersistable<Long> {



    @Column(name="iso2Code")
    private String iso2Code;

    @Column(name="countryName")
    private String countryName;
}
