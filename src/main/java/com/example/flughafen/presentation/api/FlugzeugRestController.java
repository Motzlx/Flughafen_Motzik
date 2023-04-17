package com.example.flughafen.presentation.api;

import com.example.flughafen.service.FlughafenService;
import com.example.flughafen.service.FlugzeugService;
import com.example.flughafen.service.commands.CreateFlugzeugCommand;
import com.example.flughafen.service.dtos.FlughafenDto;
import com.example.flughafen.service.dtos.FlugzeugDto;
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
@RequestMapping("/api/flugzeug")
public class FlugzeugRestController {

    private final FlugzeugService flugzeugService;



    @GetMapping
    public HttpEntity<List<FlugzeugDto>> getAllFlugzeuge() {
        return ResponseEntity.ok(flugzeugService
                .getAllFlugzeug()
                .stream()
                .map(FlugzeugDto::new)
                .toList());
    }


    @PostMapping({"", "/"})
    private HttpEntity<FlugzeugDto> createFlugzeug(@RequestBody CreateFlugzeugCommand createFlugzeugCommand) {

        return Optional.ofNullable(flugzeugService.createFlugzeug(createFlugzeugCommand.flugzeugTyp(), createFlugzeugCommand.numberOfPassengers(),createFlugzeugCommand.fuelInLitres(),
                        createFlugzeugCommand.flughafenName(),createFlugzeugCommand.iso2Code(),createFlugzeugCommand.name()))
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
