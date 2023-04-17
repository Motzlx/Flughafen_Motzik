package com.example.flughafen.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class PassagierFlug {


    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_Passagier_2_Flug"))
    private Passagier passagier;

    @Column(name = "assignment_ts")
    private LocalDate localDate;
}
