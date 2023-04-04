package com.example.flughafen.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

@Table(name="flughafen")
public class Flughafen extends AbstractPersistable<Long> {


    @Column(name = "flughafen_name")
    private String flughafenName;



    @Builder.Default
    @ElementCollection
    @CollectionTable(name = "Flughafen_flugzeug", joinColumns = @JoinColumn(name= "id", foreignKey = @ForeignKey(name ="FK_flughafen_2_flugzeug1")))
    private List<FlughafenFlugzeug> flugzeuge = new ArrayList<>();

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Country country;

    public Flughafen addFlugzeuge(Flugzeug... flugzeuge) {
        Arrays.stream(flugzeuge).forEach(flugzeug -> addFlugzeug(flugzeug));
        return this;
    }

    public Flughafen addFlugzeug(Flugzeug flugzeug) {

        Objects.requireNonNull(flugzeug, "Flugzeug cannot be null");
        FlughafenFlugzeug flughafenFlugzeug = createFlughafenFlugzeug(flugzeug);
        flugzeuge.add(flughafenFlugzeug);
        return this;
    }

    private FlughafenFlugzeug createFlughafenFlugzeug(Flugzeug flugzeug) {

        var flughafenFlugzeug = FlughafenFlugzeug.builder().flugzeug(flugzeug).build();
        return flughafenFlugzeug;
    }


}
