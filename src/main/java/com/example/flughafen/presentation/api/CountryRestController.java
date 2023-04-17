package com.example.flughafen.presentation.api;


import com.example.flughafen.model.Country;
import com.example.flughafen.service.CountryService;
import com.example.flughafen.service.commands.CreateCountryCommand;
import com.example.flughafen.service.dtos.CountryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/country")
public class CountryRestController {

    private final CountryService countryService;


    @GetMapping
    public HttpEntity<List<CountryDto>> getAllCountries() {

        return ResponseEntity.ok(countryService.getAllCountries()
                .stream()
                .map(CountryDto::new)
                .toList());

    }


   /* @PostMapping({"/add"})
    public HttpEntity<CountryDto> createCounrty(@RequestBody CreateCountryCommand createCountryCommand) {

        return Optional.ofNullable(countryService.createCountry(createCountryCommand.name(), createCountryCommand.iso2Code()))
                .map(CountryDto::new)
                .map(countryDto -> ResponseEntity.created(createCountryUri(countryDto)).body(countryDto))
                .orElse(ResponseEntity.noContent()
                        .build());

    }*/

    private URI createCountryUri(CountryDto countryDto) {

        try {

            String key = URLEncoder.encode(countryDto.name(), StandardCharsets.UTF_8);
            return new URI("/api/country/%s".formatted(key));
        }
        catch (URISyntaxException uriSyntaxException) {
            throw new RuntimeException(uriSyntaxException);
        }

    }


}
