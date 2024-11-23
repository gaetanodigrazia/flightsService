package com.digrazia.FlightsService.business.service.impl;

import com.digrazia.FlightsService.business.exception.NotFoundException;
import com.digrazia.FlightsService.business.mapper.domain.FlightDomainMapper;
import com.digrazia.FlightsService.business.model.domain.FlightInfoDomain;
import com.digrazia.FlightsService.business.service.FlightService;
import com.digrazia.FlightsService.integration.database.entity.model.FlightEntity;
import com.digrazia.FlightsService.integration.database.mapper.FlightEntityMapper;
import com.digrazia.FlightsService.integration.database.repository.FlightRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightServiceImpl implements FlightService {
    private static final Logger log = LoggerFactory.getLogger(FlightServiceImpl.class);

    private final FlightEntityMapper flightEntityMapper;
    private final FlightRepository flightRepository;
    private final FlightDomainMapper flightDomainMapper;

    @Autowired
    public FlightServiceImpl(FlightEntityMapper flightEntityMapper, FlightRepository flightRepository, FlightDomainMapper flightDomainMapper){
        this.flightEntityMapper = flightEntityMapper;
        this.flightRepository = flightRepository;
        this.flightDomainMapper = flightDomainMapper;
    }

    @Override
    public FlightInfoDomain allFlightInfo(String flightIcao) {
        FlightEntity flightEntity = flightRepository.findByIcao24(flightIcao)
                .orElseThrow(() -> new NotFoundException("Flight not found"));
        return flightDomainMapper.toFlightInfoDomain(flightEntity);
    }

    @Override
    public FlightInfoDomain reducedFlightInfo(String flightIcao) {
        FlightEntity flightEntity = flightRepository.findByIcao24(flightIcao)
                .orElseThrow(() -> new NotFoundException("Flight not found"));
        return flightDomainMapper.toFlightInfoDomain(flightEntity);
    }
}
