package com.example.flughafen.presentation.api;

import com.example.flughafen.model.Flughafen;
import com.example.flughafen.model.Flugzeug;
import com.example.flughafen.service.FlugzeugService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.assertj.core.api.Assumptions.assumeThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.List;

@WebMvcTest
public class FlugzeugRestControllerTest {

    @MockBean
    private FlugzeugService flugzeugService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        assumeThat(flugzeugService).isNotNull();
        assumeThat(mockMvc).isNotNull();

    }


    @Test
    void ensureFlugzeugIsNotEmpty() throws Exception {

        //given
        var request = get("/api/flugzeuge").accept(MediaType.APPLICATION_JSON);
        when (flugzeugService.getAllFlugzeug()).thenReturn(List.of(Flugzeug.builder()
                            .flugzeugType("Boeing")
                            .currentFlughafen(null)
                .fuelInLitres(100).numberOfPassengers(100).build()));

        //expect
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].flugzeugType").value("Boeing"))
                .andExpect(jsonPath("$[0].fuelInLietres").value(100))
                .andExpect(jsonPath("$[0].numberOfPassengers").value(100))
                .andDo(print());

    }
}
