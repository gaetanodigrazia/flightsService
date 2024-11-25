package com.digrazia.FlightsService.api.controller;

import com.digrazia.FlightsService.api.FlightsAPI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class FlightsController implements FlightsAPI {

    @Override
    @GetMapping
    public ResponseEntity<String> simpleGet() {
        return ResponseEntity.ok("simpleGet");
    }
}
