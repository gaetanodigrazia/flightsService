package com.digrazia.FlightsService.business.service.impl;

import com.digrazia.FlightsService.business.exception.NotFoundException;
import com.digrazia.FlightsService.business.mapper.domain.AirportDomainMapper;
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
    private final AirportDomainMapper airportDomainMapper;

    public AirportServiceImpl(AirportDomainMapper airportDomainMapper) {

        this.airportDomainMapper = airportDomainMapper;
    }


    @Override
    public AirportDomain airportInfo(String airportIcao) {
        AirportEntity airportEntity = airportRepository.findByIcao(airportIcao).orElseThrow(() -> new NotFoundException("Airport not found"));

        return airportDomainMapper.fromEntityToDomain(airportEntity);
    }

}
