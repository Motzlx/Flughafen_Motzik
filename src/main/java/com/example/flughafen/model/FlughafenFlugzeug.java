package com.example.flughafen.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class FlughafenFlugzeug {

    @ManyToOne (cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_flughafen_2_flugzeug"))
    private Flugzeug flugzeug;

    @Column(name = "assignment_ts")
    private LocalDateTime timeStamp;



}
