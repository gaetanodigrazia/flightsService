package com.digrazia.FlightsService.api;

import com.digrazia.FlightsService.business.model.dto.AirportDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public interface AirportAPI {

    ResponseEntity<String> simpleGet();

    AirportDTO getAirportInfo(@PathVariable String airportIcao);
}
