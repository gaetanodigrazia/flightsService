package com.digrazia.FlightsService.api;

import com.digrazia.FlightsService.business.model.dto.UserDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;

public interface UserAPI {
   @Operation(operationId = "userDetails", description = "userDetails")
   @ApiResponses(value = {
           @ApiResponse(responseCode = "200", description = "userDetails",
                   content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                           schema = @Schema(implementation = UserDTO.class))),
   })
   UserDTO userDetails();
}
