package com.example.flughafen.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.*;



// Abstract class for people
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder

@Embeddable
public class Address {

    @Column(length = 64)
    private String streetNumber;
    @Column(length = 16)
    private String zipCode;
    @Column(length = 64)
    private String city;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Country country;

}
