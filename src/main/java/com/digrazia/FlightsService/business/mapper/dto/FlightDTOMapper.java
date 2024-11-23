package com.digrazia.FlightsService.business.mapper.dto;

import com.digrazia.FlightsService.business.model.domain.AirportDomain;
import com.digrazia.FlightsService.business.model.domain.FlightInfoDomain;
import com.digrazia.FlightsService.business.model.dto.AirportDTO;
import com.digrazia.FlightsService.business.model.dto.FlightDTO;
import com.digrazia.FlightsService.business.model.dto.ReducedAirportDTO;
import com.digrazia.FlightsService.business.model.dto.ReducedFlightDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FlightDTOMapper {

    FlightDTO fromFlightInfoDomainToFlightDTO(FlightInfoDomain flightInfoDomain);
    ReducedFlightDTO fromFlightInfoDomainToReducedFlightDTO(FlightInfoDomain flightInfoDomain);
}
