package com.digrazia.FlightsService.business.service.impl;

import com.digrazia.FlightsService.business.exception.NotFoundException;
import com.digrazia.FlightsService.business.mapper.entity.AirportEntityMapper;
import com.digrazia.FlightsService.business.model.domain.AirportDomain;
import com.digrazia.FlightsService.business.service.AirportService;
import com.digrazia.FlightsService.integration.database.entity.model.AirportEntity;
import com.digrazia.FlightsService.integration.database.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirportServiceImpl implements AirportService {
    @Autowired
    private AirportRepository airportRepository;
    private final AirportEntityMapper airportEntityMapper;

    public AirportServiceImpl(AirportEntityMapper airportEntityMapper) {

        this.airportEntityMapper = airportEntityMapper;
    }

    @Override
    public AirportDomain airportInfo(String icao) {
        AirportEntity airportEntity = airportRepository.findByIcao(icao).orElseThrow(() -> new NotFoundException("Airport Icao Not Found"));
        return airportEntityMapper.fromEntityToDomain(airportEntity);
    }
}
