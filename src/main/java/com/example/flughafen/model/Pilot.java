package com.example.flughafen.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name = "pilots")
public class Pilot extends AbstractPerson {

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name ="streetNumber", column = @Column(name = "appartment_street_number", length=64)),
            @AttributeOverride(name = "zipCode", column = @Column(name = "appartment_zip_code", length=16)),
            @AttributeOverride(name = "city", column = @Column(name = "appartment_city", length=64)),
    })
    @AssociationOverrides({
            @AssociationOverride(name = "country",
                    joinColumns = {@JoinColumn(name = "studio_country_id")},
                    foreignKey = @ForeignKey(name = "FK_pilot_appartment_country"))
    })
    private Address appartmentAddress;
    @Column(name = "noOfFlights")
    private Integer noOfFlights;

    @Column(name = "yearOfGraduation")
    private LocalDateTime yearOfGraduation;


    @ElementCollection
    @CollectionTable(name="pilot_emails", joinColumns = @JoinColumn(name="pilotId", foreignKey = @ForeignKey(name = "FK_pilot_emails") ))
    @OrderColumn(name = "position")
    private Set<Email> emailAddresses = new HashSet<>(2);


    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name ="countryCode", column = @Column(name = "mobile_country_code")),
            @AttributeOverride(name = "areaCode", column = @Column(name = "mobile_area_code")),
            @AttributeOverride(name = "serialNumber", column = @Column(name = "mobile_serial_number", length=16)),
    })
    private PhoneNumber mobilePhoneNumber;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name ="countryCode", column = @Column(name = "business_country_code")),
            @AttributeOverride(name = "areaCode", column = @Column(name = "business_area_code")),
            @AttributeOverride(name = "serialNumber", column = @Column(name = "business_serial_number", length=16)),
    })
    private PhoneNumber businessPhoneNumber;



    @Builder
    public Pilot(String userName, String firstName, String lastName, Integer noOfFlights, LocalDateTime yearOfGraduation) {
        super(userName, firstName, lastName);
        this.noOfFlights = noOfFlights;
        this.yearOfGraduation = yearOfGraduation;
    }
}
