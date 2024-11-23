package com.digrazia.FlightsService.business.model.dto;

public class AirportDTO {
    String airportId;
    String icao;
    String iata;
    String name;
    String city;
    String region;
    String country;
    int elevationFt;
    double latitude;
    double longitude;
    String timezone;

    public AirportDTO(String airportId, String icao,
                      String iata, String name, String city,
                      String region, String country, int elevationFt,
                      double latitude, double longitude, String timezone) {
        this.airportId = airportId;
        this.icao = icao;
        this.iata = iata;
        this.name = name;
        this.city = city;
        this.region = region;
        this.country = country;
        this.elevationFt = elevationFt;
        this.latitude = latitude;
        this.longitude = longitude;
        this.timezone = timezone;
    }

    public String getAirportId() {
        return airportId;
    }

    public void setAirportId(String airportId) {
        this.airportId = airportId;
    }

    public String getIcao() {
        return icao;
    }

    public void setIcao(String icao) {
        this.icao = icao;
    }

    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getElevationFt() {
        return elevationFt;
    }

    public void setElevationFt(int elevationFt) {
        this.elevationFt = elevationFt;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }


}
