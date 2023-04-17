package com.example.flughafen.presentation.api;

import com.example.flughafen.service.FlughafenService;
import com.example.flughafen.service.FlugzeugService;
import com.example.flughafen.service.dtos.FlughafenDto;
import com.example.flughafen.service.dtos.FlugzeugDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/flugzeug")
public class FlugzeugRestController {

    private final FlugzeugService flugzeugService;



    public HttpEntity<List<FlugzeugDto>> getAllFlugzeuge() {
        return ResponseEntity.ok(flugzeugService
                .getAllFlugzeug()
                .stream()
                .map(FlugzeugDto::new)
                .toList());


    }


    private HttpEntity<FlugzeugDto> createFlugzeug(String flugzeugBezeichnung, int fuelInLitres, int numberOfPassangers, String flughafenName, String iso2Code, String countryName) {

        return Optional.ofNullable(flugzeugService.createFlugzeug(flugzeugBezeichnung,fuelInLitres,numberOfPassangers,flughafenName,iso2Code,countryName))
                .map(FlugzeugDto::new)
                .map(flugzeugDto -> ResponseEntity.created(createFlugzeugUri(flugzeugDto)).body(flugzeugDto))
                .orElse(ResponseEntity.noContent()
                        .build());
    }

    private URI createFlugzeugUri(FlugzeugDto dto) {
        try {
            String key = URLEncoder.encode(dto.flugzeugTyp(), StandardCharsets.UTF_8);
            return new URI("/api/flugzeug/%s".formatted(key));
        } catch (URISyntaxException uriSyntaxEx) {
            throw new RuntimeException(uriSyntaxEx);
        }
    }
}
