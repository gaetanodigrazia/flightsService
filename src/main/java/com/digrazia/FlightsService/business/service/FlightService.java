package com.digrazia.FlightsService.business.service;


import com.digrazia.FlightsService.business.model.domain.FlightInfoDomain;

public interface FlightService {
    FlightInfoDomain allFlightInfo(String flightIcao);
    FlightInfoDomain reducedFlightInfo(String flightIcao);
}
