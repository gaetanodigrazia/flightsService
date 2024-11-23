package com.digrazia.FlightsService.business.mapper.dto;

import com.digrazia.FlightsService.business.model.domain.AirportDomain;
import com.digrazia.FlightsService.business.model.dto.AirportDTO;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.digrazia.FlightsService.business.mapper.useCase.AirportUseCaseBuilder.whenMapperMethodTest;
import static org.junit.Assert.assertEquals;

@SpringBootTest
public class AirportDTOMapperTest {
    @Autowired
    private AirportDTOMapper mapper;

    @Nested
    class fromAirportDomainToAirportDTO{

        @Test
        void whenFullCorrectObjects_thenOk(){
            AirportDTO expectedAirportDTO = whenMapperMethodTest()._1;
            AirportDomain toMapAirportDomain = whenMapperMethodTest()._2;

            AirportDTO actualAirportDTO = mapper.fromAirportDomainToAirportDTO(toMapAirportDomain);

            assertEquals(expectedAirportDTO, actualAirportDTO);
        }

    }


}
