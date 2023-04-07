package com.example.flughafen.service.dtos;

import com.example.flughafen.model.Flugzeug;

public record FlugzeugDto(String flugzeugTyp, Integer numberOfPassengers, Integer fuelInLitres, FlughafenDto currentFlughafen) {


    public FlugzeugDto(Flugzeug flugzeug) {
        this(flugzeug.getFlugzeugType(), flugzeug.getNumberOfPassengers(), flugzeug.getFuelInLitres(),
                new FlughafenDto(flugzeug.getCurrentFlughafen()));
    }


}
