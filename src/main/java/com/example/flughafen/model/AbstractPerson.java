package com.example.flughafen.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

// Abstract class for persistable person
@Data
@MappedSuperclass
@NoArgsConstructor
public abstract class AbstractPerson extends AbstractPersistable<Long> {

    @Column(length = 255)
    private String userName;

    @Embedded
    @Column(name = "address")
    private Address address;


    @Column(length = 32)
    private String firstName;

    @Column(length = 64)
    private String lastName;

    public AbstractPerson(String userName, String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
    }
}
