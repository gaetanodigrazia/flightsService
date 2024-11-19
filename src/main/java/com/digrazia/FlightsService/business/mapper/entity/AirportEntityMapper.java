package com.digrazia.FlightsService.business.mapper.entity;

import com.digrazia.FlightsService.business.model.domain.AirportDomain;
import com.digrazia.FlightsService.integration.database.entity.model.AirportEntity;
import com.digrazia.FlightsService.integration.kafka.model.AirportKafkaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AirportEntityMapper {
        AirportEntity fromDomainToEntity(AirportDomain airportDomain);
        AirportDomain fromEntityToDomain(AirportEntity airportEntity);
        AirportEntity fromKafkaEntityToEntity(AirportKafkaEntity airportEntity);
}
