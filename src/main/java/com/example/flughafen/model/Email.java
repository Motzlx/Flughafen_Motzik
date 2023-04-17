package com.example.flughafen.model;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class Email {

    @Column(name = "Email")
    private String address;

    @Column(name = "EmailType")
    private EmailType type;
}
