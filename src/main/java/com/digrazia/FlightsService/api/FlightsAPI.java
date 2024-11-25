package com.digrazia.FlightsService.api;

import org.springframework.http.ResponseEntity;

public interface FlightsAPI {

    ResponseEntity<String> simpleGet();
}
