package com.digrazia.FlightsService.business.model.dto;

public class ReducedAirportDTO extends AirportDTO {
    String name;
    String city;
    String region;
    String country;


    public ReducedAirportDTO(String name, String city, String region, String country) {
        super(null, null, null, name, city, region, country, 0, 0,
                0, null);
        this.name = name;
        this.city = city;
        this.region = region;
        this.country = country;
    }
}
