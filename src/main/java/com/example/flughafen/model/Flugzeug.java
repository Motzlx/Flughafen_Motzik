package com.example.flughafen.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Flugzeug")
public class Flugzeug extends AbstractPersistable<Long> {


    @Column(name = "FlugzeugType")
    private String flugzeugType;

    @Column(name = "numOfPassangers")
    private int numberOfPassengers;

    @Column(name = "fuelInLitres")
    private int fuelInLitres;



    @ManyToOne
    @JoinColumn(foreignKey =  @ForeignKey(name="FK_flugzeug_2_flughafen"))
    private Flughafen currentFlughafen;

    @OneToMany
    private List<Flug> geflogeneFluege;




}
