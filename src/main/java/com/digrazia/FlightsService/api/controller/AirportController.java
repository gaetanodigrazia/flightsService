package com.digrazia.FlightsService.api.controller;

import com.digrazia.FlightsService.api.AirportAPI;
import com.digrazia.FlightsService.business.mapper.dto.AirportDTOMapper;
import com.digrazia.FlightsService.business.model.domain.AirportDomain;
import com.digrazia.FlightsService.business.model.dto.AirportDTO;
import com.digrazia.FlightsService.business.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AirportController implements AirportAPI {
    private final AirportDTOMapper airportDTOMapper;
    private final AirportService airportService;

    @Autowired
    public AirportController(AirportDTOMapper airportDTOMapper, AirportService airportService) {
        this.airportDTOMapper = airportDTOMapper;
        this.airportService = airportService;
    }



    @Override
    @GetMapping("/admin/airportInfo/{airportIcao}")
    public AirportDTO getAirportInfo(@PathVariable String airportIcao) {
        AirportDomain airportDomain = airportService.airportInfo(airportIcao);
        return airportDTOMapper.fromAirportDomainToAirportDTO(airportDomain);
    }
}
