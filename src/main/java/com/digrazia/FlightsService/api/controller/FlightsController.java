package com.digrazia.FlightsService.api.controller;

import com.digrazia.FlightsService.api.FlightsAPI;
import com.digrazia.FlightsService.business.mapper.domain.FlightDomainMapper;
import com.digrazia.FlightsService.business.mapper.dto.FlightDTOMapper;
import com.digrazia.FlightsService.business.model.domain.FlightInfoDomain;
import com.digrazia.FlightsService.business.model.dto.FlightDTO;
import com.digrazia.FlightsService.business.model.dto.ReducedFlightDTO;
import com.digrazia.FlightsService.business.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class FlightsController implements FlightsAPI {
    private final FlightService flightService;
    private final FlightDTOMapper flightDTOMapper;

    @Autowired
    public FlightsController(FlightService flightService, FlightDTOMapper flightDTOMapper) {
        this.flightService = flightService;
        this.flightDTOMapper = flightDTOMapper;
    }


    @Override
    @GetMapping("/admin/flight/info/{flightIcao}")
    public FlightDTO getAllFlightInfo(String flightIcao) {
        FlightInfoDomain flightInfoDomain = flightService.allFlightInfo(flightIcao);

        return flightDTOMapper.fromFlightInfoDomainToFlightDTO(flightInfoDomain);
    }

    @Override
    @GetMapping("/user/flight/info")
    public ReducedFlightDTO getReducedFlightInfo(String flightIcao) {
        FlightInfoDomain flightInfoDomain = flightService.reducedFlightInfo(flightIcao);

        return flightDTOMapper.fromFlightInfoDomainToReducedFlightDTO(flightInfoDomain);
    }
}


