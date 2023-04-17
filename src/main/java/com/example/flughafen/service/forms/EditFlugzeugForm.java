package com.example.flughafen.service.forms;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class EditFlugzeugForm {

    @NotBlank @Size(min=2,max=20)
    private String flugzeugBezeichnung;

    @Positive @Max(1000)
    private int fuelInLitres;

    @Positive @Max(250)
    private int numOfPassangers;


    private Long id;

    /*@NotNull
    String flugzeugKey;*/

}
