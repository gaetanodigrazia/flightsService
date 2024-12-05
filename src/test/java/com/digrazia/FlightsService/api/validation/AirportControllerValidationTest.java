package com.digrazia.FlightsService.api.validation;

import com.digrazia.FlightsService.api.controller.AirportController;
import com.digrazia.FlightsService.business.mapper.dto.AirportDTOMapper;
import com.digrazia.FlightsService.business.mapper.dto.AirportDTOMapperTest;
import com.digrazia.FlightsService.business.service.AirportService;
import com.digrazia.FlightsService.business.validator.annotations.lengthControl.LengthControl;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
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
        @WithMockUser(username = "admin", roles = {"ADMIN"})
        void whenPathParameterTooLong_thenBadRequest() throws Exception {
            String parameter = "123456789123456789123456";
            MvcResult mvcResult = mockMvc.perform(get("/api/admin/airportInfo/{airportIcao}", parameter))
                    .andExpect(status().isBadRequest())
                    .andReturn();

            assertEquals("Valore PathVariable max length: 10", mvcResult.getResponse().getContentAsString());
            }


        @Test
        @WithMockUser(username = "admin", roles = {"ADMIN"})
        void whenPathParameterLengthIsOk_thenOk() throws Exception {
            mockMvc.perform(get("/api/admin/airportInfo/{airportIcao}", "1234"))
                    .andExpect(status().isOk());
        }

    }

}
