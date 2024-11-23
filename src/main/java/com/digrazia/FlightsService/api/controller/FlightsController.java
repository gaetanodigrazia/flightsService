package com.digrazia.FlightsService.api.controller;

import com.digrazia.FlightsService.api.FlightsAPI;
import com.digrazia.FlightsService.business.service.FlightService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class FlightsController implements FlightsAPI {
    private final FlightService flightService;

    public FlightsController(FlightService flightService) {
        this.flightService = flightService;
    }


    @Override
    @GetMapping("/admin/flight/allInfo")
    public String getAllFlightInfo(String flightId) {
        return "";
    }

    @Override
    @GetMapping("/user/flight/info")
    public String getReducedFlightInfo(String flightId) {
        return "";
    }
}


