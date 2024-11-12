package com.digrazia.FlightsService.api;

import org.springframework.http.ResponseEntity;

public interface AirportAPI {

    ResponseEntity<String> simpleGet();
}
