package com.example.flughafen.presentation.api;

import com.example.flughafen.service.FlughafenService;
import com.example.flughafen.service.commands.CreateFlughafenCommand;
import com.example.flughafen.service.dtos.FlughafenDto;
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
@RequestMapping("/api/flughafen")
public class FlughafenRestController {

    private final FlughafenService flughafenService;


    @GetMapping({"", "/"})
    public HttpEntity<List<FlughafenDto>> getAllFlughafen () {

        return ResponseEntity.ok(flughafenService
                .getAllFlugenhafen()
                .stream()
                .map(FlughafenDto::new)
                .toList());
    }

    private URI createFlughafenUri(FlughafenDto dto) {
        try {
            String key = URLEncoder.encode(dto.flughafenName(), StandardCharsets.UTF_8);
            return new URI("/api/flughafen/%s".formatted(key));
        } catch (URISyntaxException uriSyntaxEx) {
            throw new RuntimeException(uriSyntaxEx);
        }
    }

    @PostMapping({"", "/"})
    public HttpEntity<FlughafenDto> createFlughafen(@RequestBody CreateFlughafenCommand flughafenCommand) {

        return Optional.ofNullable(flughafenService.createFlughafen(flughafenCommand.flughafenName(), flughafenCommand.name(), flughafenCommand.iso2Code()))
                .map(FlughafenDto::new)
                .map(dto -> ResponseEntity.created(createFlughafenUri(dto)).body(dto))
                .orElse(ResponseEntity.noContent().build());

    }
}
