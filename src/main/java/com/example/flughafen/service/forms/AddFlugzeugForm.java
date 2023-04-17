package com.example.flughafen.service.forms;


import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddFlugzeugForm {

    @NotBlank @Size(min=2,max=20)
    private String flugzeugBezeichnung;

    @Positive @Max(1000)
    private int fuelInLitres;

    @Positive @Max(250)
    private int numOfPassangers;

    private String iso2Code;

    private String countryName;

    private String flughafenName;

    /*@NotNull
    String flugzeugKey;*/

}
