package com.digrazia.FlightsService.api;

import com.digrazia.FlightsService.business.model.dto.BookingOutputDTO;
import org.springframework.http.ResponseEntity;

public interface FlightsAPI {
    String getAllFlightInfo(String flightId);
    String getReducedFlightInfo(String flightId);
}
