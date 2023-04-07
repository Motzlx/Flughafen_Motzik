package com.example.flughafen.presentation.api;

import com.example.flughafen.service.FlughafenService;
import com.example.flughafen.service.dtos.FlughafenDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/flughafen")
public class FlughafenRestController {

    private final FlughafenService flughafenService;


    @GetMapping({"", "/"})
    public HttpEntity<FlughafenDto> getAllFlughafen () {

        return ResponseEntity.ok(flughafenService



        )
        return null;
    }
}
