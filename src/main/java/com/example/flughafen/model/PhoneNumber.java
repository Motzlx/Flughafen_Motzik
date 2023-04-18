package com.example.flughafen.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Min;
import lombok.*;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder

@Embeddable
public class PhoneNumber {
    @Min(1)
    private Integer countryCode;
    @Min(1)
    private Integer areaCode;
    @Column(length = 16)
    private String serialNumber;
}
