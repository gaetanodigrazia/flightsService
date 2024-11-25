package com.digrazia.FlightsService.business.mapper.dto;

import com.digrazia.FlightsService.business.model.domain.AirportDomain;
import com.digrazia.FlightsService.business.model.dto.AirportDTO;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.digrazia.FlightsService.utils.useCase.AirportUseCaseBuilder.fromAirportDomainToAirportDTO;
import static com.digrazia.FlightsService.utils.useCase.AirportUseCaseBuilder.fromAirportDomainToReducedAirportDTO;
import static com.digrazia.FlightsService.utils.AirportAssert.fromAirportDomainToAirportDTOAssertions;
import static com.digrazia.FlightsService.utils.AirportAssert.fromAirportDomainToReducedAirportDTOAssertions;

@SpringBootTest
public class UserDTOMapperTest {
    @Autowired
    private AirportDTOMapper mapper;

    @Nested
    class fromAirportDomainToAirportDTO{

        @Test
        void whenFullCorrectObjects_thenOk(){
            AirportDTO expectedAirportDTO = fromAirportDomainToAirportDTO()._1;
            AirportDomain toMapAirportDomain = fromAirportDomainToAirportDTO()._2;

            AirportDTO actualAirportDTO = mapper.fromAirportDomainToAirportDTO(toMapAirportDomain);

            fromAirportDomainToAirportDTOAssertions(expectedAirportDTO, actualAirportDTO);
        }
    }

    @Nested
    class fromAirportDomainToReducedAirportDTO{

        @Test
        void whenFullCorrectObjects_thenOk(){
            AirportDTO expectedAirportDTO = fromAirportDomainToReducedAirportDTO()._1;
            AirportDomain toMapAirportDomain = fromAirportDomainToReducedAirportDTO()._2;

            AirportDTO actualAirportDTO = mapper.fromAirportDomainToReducedAirportDTO(toMapAirportDomain);

            fromAirportDomainToReducedAirportDTOAssertions(expectedAirportDTO, actualAirportDTO);
        }

    }



}
