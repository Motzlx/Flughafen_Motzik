package com.example.flughafen.service.commands;

import com.example.flughafen.service.dtos.CountryDto;

public record CreateFlughafenCommand(String flughafenName, String name, String iso2Code) {



}
