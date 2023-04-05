package com.example.flughafen.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.time.LocalDateTime;
import java.util.List;

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


    @OneToMany
    private List<Passagier> passagierList;

    private LocalDateTime abflugZeit;

    private LocalDateTime ankunftsZeit;

}
