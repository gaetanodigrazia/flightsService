package com.digrazia.FlightsService.business.service;


import com.digrazia.FlightsService.business.model.domain.AirportDomain;

public interface AirportService {
    AirportDomain airportInfo(String airportIcao);
}
