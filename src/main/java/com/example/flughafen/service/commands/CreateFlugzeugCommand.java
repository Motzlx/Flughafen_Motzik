package com.example.flughafen.service.commands;

import com.example.flughafen.service.dtos.FlughafenDto;

public record CreateFlugzeugCommand(String flugzeugTyp, int numberOfPassengers, int fuelInLitres, String flughafenName, String name,
                                    String iso2Code) {
}
