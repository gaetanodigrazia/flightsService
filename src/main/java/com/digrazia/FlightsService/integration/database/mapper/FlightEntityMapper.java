package com.digrazia.FlightsService.integration.database.mapper;

import com.digrazia.FlightsService.integration.database.entity.model.FlightEntity;
import com.digrazia.FlightsService.integration.kafka.model.FlightInfoKafkaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FlightEntityMapper {
        FlightEntity fromKafkaEntityToEntity(FlightInfoKafkaEntity flightInfoKafkaEntity);

}
