package com.example.flughafen.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;
import java.util.List;

@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class Passagier extends AbstractPerson {
    @OneToMany
    private List<Flug> fluege;

    @OneToOne
    private Country country;



    @Builder
    public Passagier(String userName, String firstName, String lastName) {
        super(userName, firstName, lastName);
    }
}
