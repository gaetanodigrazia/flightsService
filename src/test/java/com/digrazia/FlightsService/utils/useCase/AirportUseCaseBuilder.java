package com.digrazia.FlightsService.utils.useCase;

import com.digrazia.FlightsService.business.model.domain.AirportDomain;
import com.digrazia.FlightsService.business.model.dto.AirportDTO;
import com.digrazia.FlightsService.business.model.dto.ReducedAirportDTO;
import scala.Tuple2;

import static com.digrazia.FlightsService.builder.AirportBuilder.buildAirportDTO;
import static com.digrazia.FlightsService.builder.AirportBuilder.buildAirportDomain;
import static com.digrazia.FlightsService.builder.AirportBuilder.buildReducedAirportDTO;

public class AirportUseCaseBuilder {

    public static Tuple2<AirportDTO, AirportDomain> fromAirportDomainToAirportDTO(){
        return new Tuple2<>(buildAirportDTO(), buildAirportDomain());
    }

    public static Tuple2<ReducedAirportDTO, AirportDomain> fromAirportDomainToReducedAirportDTO(){
        return new Tuple2<>(buildReducedAirportDTO(), buildAirportDomain());
    }
}
