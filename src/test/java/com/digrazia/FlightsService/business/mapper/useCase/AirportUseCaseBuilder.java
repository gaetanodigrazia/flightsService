package com.digrazia.FlightsService.business.mapper.useCase;

import com.digrazia.FlightsService.business.model.domain.AirportDomain;
import com.digrazia.FlightsService.business.model.dto.AirportDTO;
import scala.Tuple2;

import static com.digrazia.FlightsService.builder.AirportBuilder.buildAirportDTO;
import static com.digrazia.FlightsService.builder.AirportBuilder.buildAirportDomain;

public class AirportUseCaseBuilder {

    public static Tuple2<AirportDTO, AirportDomain> whenMapperMethodTest(){
        return new Tuple2<>(buildAirportDTO(), buildAirportDomain());
    }
}
