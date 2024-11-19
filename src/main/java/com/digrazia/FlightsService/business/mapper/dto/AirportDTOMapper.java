package com.digrazia.FlightsService.business.mapper.dto;

import com.digrazia.FlightsService.business.model.domain.AirportDomain;
import com.digrazia.FlightsService.business.model.dto.AirportDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AirportDTOMapper {
    AirportDTO fromDomainToDTO(AirportDomain airportDomain);

    @Mapping(target = "id", ignore = true)
    AirportDomain fromDTOToDomain(AirportDTO airportDTO);
}
