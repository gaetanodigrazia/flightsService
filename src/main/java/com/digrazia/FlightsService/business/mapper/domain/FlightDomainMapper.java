package com.digrazia.FlightsService.business.mapper.domain;

import com.digrazia.FlightsService.business.model.domain.AirportDomain;
import com.digrazia.FlightsService.business.model.domain.FlightInfoDomain;
import com.digrazia.FlightsService.integration.database.entity.model.AirportEntity;
import com.digrazia.FlightsService.integration.database.entity.model.FlightEntity;
import com.digrazia.FlightsService.integration.kafka.model.AirportKafkaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FlightDomainMapper {
        FlightInfoDomain toFlightInfoDomain(FlightEntity flightEntity);

}
