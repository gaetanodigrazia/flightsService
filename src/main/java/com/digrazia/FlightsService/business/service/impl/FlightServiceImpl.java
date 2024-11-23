package com.digrazia.FlightsService.business.service.impl;

import com.digrazia.FlightsService.business.service.FlightService;
import com.digrazia.FlightsService.integration.database.mapper.FlightEntityMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightServiceImpl implements FlightService {
    private static final Logger log = LoggerFactory.getLogger(FlightServiceImpl.class);

    private final FlightEntityMapper flightEntityMapper;

    @Autowired
    public FlightServiceImpl(FlightEntityMapper flightEntityMapper){
        this.flightEntityMapper = flightEntityMapper;

    }
}
