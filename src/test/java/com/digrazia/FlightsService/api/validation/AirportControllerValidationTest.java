package com.digrazia.FlightsService.api.validation;

import com.digrazia.FlightsService.api.controller.AirportController;
import com.digrazia.FlightsService.business.mapper.dto.AirportDTOMapper;
import com.digrazia.FlightsService.business.mapper.dto.AirportDTOMapperTest;
import com.digrazia.FlightsService.business.service.AirportService;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AirportController.class)
@AutoConfigureMockMvc
public class AirportControllerValidationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AirportService airportService;

    @MockBean
    private AirportDTOMapper airportDTOMapper;

    @Nested
    class getAirportInfo {

        @Test
        void whenPathParameterTooLong_thenBadRequest() throws Exception {
            mockMvc.perform(get("/api/admin/airportInfo/{airportIcao}")
                            .param("airportIcao", "123456789123456789123456"))
                    .andExpect(status().isOk());
        }
    }

}
