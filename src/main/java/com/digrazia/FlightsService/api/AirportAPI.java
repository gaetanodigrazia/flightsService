package com.digrazia.FlightsService.api;

import com.digrazia.FlightsService.business.model.dto.AirportDTO;
import com.digrazia.FlightsService.business.model.dto.ReducedAirportDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;

public interface AirportAPI {

    @Operation(operationId = "getAllAirportInfo", description = "getAllAirportInfo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "getAllAirportInfo",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = AirportDTO.class))),
    })
    AirportDTO getAllAirportInfo(@PathVariable(name = "airportIcao") String airportIcao);

    @Operation(operationId = "getAirportInfo", description = "getAirportInfo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "getAirportInfo",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ReducedAirportDTO.class))),
    })
    ReducedAirportDTO getAirportInfo(@PathVariable(name = "airportIcao") String airportIcao);
}
