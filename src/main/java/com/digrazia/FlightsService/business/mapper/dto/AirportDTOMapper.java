package com.digrazia.FlightsService.business.mapper.dto;

import com.digrazia.FlightsService.business.model.domain.AirportDomain;
import com.digrazia.FlightsService.business.model.dto.AirportDTO;
import com.digrazia.FlightsService.business.model.dto.ReducedAirportDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AirportDTOMapper {

    AirportDTO fromAirportDomainToAirportDTO(AirportDomain airportDomain);
    ReducedAirportDTO fromAirportDomainToReducedAirportDTO(AirportDomain airportDomain);
}
