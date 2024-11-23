package com.digrazia.FlightsService.builder;

import com.digrazia.FlightsService.business.model.domain.AirportDomain;
import com.digrazia.FlightsService.business.model.dto.AirportDTO;
import com.digrazia.FlightsService.business.model.dto.ReducedAirportDTO;

public class FlightBuilder {
    private static String id = "1";
    private static String airportId = "A001";
    private static String icao = "KATL";
    private static String iata = "ATL";
    private static String name = "Hartsfield-Jackson Atlanta International Airport";
    private static String city = "Atlanta";
    private static String region = "Georgia";
    private static String country = "United States";

    private static int elevationFt = 1026;
    private static double latitude = 33.6407;
    private static double longitude = -84.4279;
    private static String timezone = "America/New_York";

    public static AirportDomain buildAirportDomain() {
        AirportDomain airportDomain = new AirportDomain();
        airportDomain.setId(id);
        airportDomain.setAirportId(airportId);
        airportDomain.setIata(iata);
        airportDomain.setIcao(icao);
        airportDomain.setName(name);
        airportDomain.setCity(city);
        airportDomain.setRegion(region);
        airportDomain.setCountry(country);
        airportDomain.setElevationFt(elevationFt);
        airportDomain.setLatitude(latitude);
        airportDomain.setLongitude(longitude);
        airportDomain.setTimezone(timezone);
        return airportDomain;

    }

    public static AirportDTO buildAirportDTO() {
        return new AirportDTO(airportId, icao, iata, name, city,
                region, country, elevationFt,
                latitude, longitude, timezone);
    }

    public static ReducedAirportDTO buildReducedAirportDTO() {
        return new ReducedAirportDTO(name, city, region, country);
    }
}
