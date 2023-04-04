package com.example.flughafen.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Data
@MappedSuperclass
@NoArgsConstructor
public abstract class AbstractPerson extends AbstractPersistable<Long> {



    @Column(length = 255)
    private String userName;


    @Column(length = 32)
    private String firstName;


    @Column(length = 64)
    private String lastName;

    public AbstractPerson(String userName, String firstName, String lastName) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
    }



}
