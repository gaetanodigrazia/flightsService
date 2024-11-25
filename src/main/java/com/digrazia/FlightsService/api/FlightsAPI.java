package com.digrazia.FlightsService.api;

import com.digrazia.FlightsService.business.model.dto.AirportDTO;
import com.digrazia.FlightsService.business.model.dto.BookingOutputDTO;
import com.digrazia.FlightsService.business.model.dto.FlightDTO;
import com.digrazia.FlightsService.business.model.dto.ReducedAirportDTO;
import com.digrazia.FlightsService.business.model.dto.ReducedFlightDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public interface FlightsAPI {

    @Operation(operationId = "getAllFlightInfo", description = "getAllFlightInfo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "getAllFlightInfo",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = FlightDTO.class))),
    })
    FlightDTO getAllFlightInfo(@PathVariable(name = "airportIcao") String airportIcao);


    @Operation(operationId = "getReducedFlightInfo", description = "getReducedFlightInfo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "getReducedFlightInfo",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ReducedFlightDTO.class))),
    })
    ReducedFlightDTO getReducedFlightInfo(@PathVariable(name = "airportIcao") String airportIcao);
}
