package com.digrazia.FlightsService.business.model.dto;

public record AirportDTO(String airportId,
                         String icao, String iata,
                         String name, String city,
                         String region, String country,
                         int elevationFt, double latitude,
                         double longitude, String timezone) {
}
