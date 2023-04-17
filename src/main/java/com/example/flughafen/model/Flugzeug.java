package com.example.flughafen.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Flugzeug")
public class Flugzeug extends AbstractPersistable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "FlugzeugType")
    private String flugzeugType;

    @Column(name = "numOfPassangers")
    private int numberOfPassengers;


    @Column(name = "fuelInLitres")
    private int fuelInLitres;



    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(foreignKey =  @ForeignKey(name="FK_flugzeug_2_flughafen"))
    private Flughafen currentFlughafen;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Flug> geflogeneFluege;


    public Flughafen getCurrentFlughafen() {
        return currentFlughafen;
    }
}
