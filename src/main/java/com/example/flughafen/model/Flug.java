package com.example.flughafen.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="Flug")
@Data
@Table
public class Flug extends AbstractPersistable<Long> {


    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST, CascadeType.REFRESH})
    private Flugzeug flugzeug;

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST, CascadeType.REFRESH})
    private Flughafen destinationFlughafen;

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST, CascadeType.REFRESH})
    private Flughafen sourceFlughafen;


    @Builder.Default
    @ElementCollection
    @CollectionTable(name = "Passagier_flug", joinColumns = @JoinColumn(name= "id", foreignKey = @ForeignKey(name ="FK_passagier_2_flug1")))
    private List<PassagierFlug> passagierList = new ArrayList<>();

    private LocalDateTime abflugZeit;

    private LocalDateTime ankunftsZeit;

    public Flug addPassagiere(Passagier... passagiere) {
        Arrays.stream(passagiere).forEach(passagier -> addPassagier(passagier));
        return this;
    }

    public Flug addPassagier(Passagier passagier) {

        Objects.requireNonNull(passagier, "passagier cannot be null");
        PassagierFlug passagierFlug = createPassagierFlug(passagier);
        passagierList.add(passagierFlug);
        return this;
    }

    private PassagierFlug createPassagierFlug(Passagier passagier) {


            var passagierFlug = PassagierFlug.builder().passagier(passagier).build();
            return passagierFlug;
        }
}



