package com.digrazia.FlightsService.business.model.domain;

import java.util.Objects;

public class AirportDomain {
    private String id;
    private String airportId;
    private String icao;
    private String iata;
    private String name;
    private String city;
    private String region;
    private String country;

    private int elevationFt;
    private double latitude;
    private double longitude;
    private String timezone;

    public AirportDomain(String id, String airportId, String icao, String iata, String name, String city, String region, String country, int elevationFt, double latitude, double longitude, String timezone) {
        this.id = id;
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

    public AirportDomain() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AirportDomain that = (AirportDomain) o;
        return elevationFt == that.elevationFt && Double.compare(latitude, that.latitude) == 0 && Double.compare(longitude, that.longitude) == 0 && Objects.equals(id, that.id) && Objects.equals(airportId, that.airportId) && Objects.equals(icao, that.icao) && Objects.equals(iata, that.iata) && Objects.equals(name, that.name) && Objects.equals(city, that.city) && Objects.equals(region, that.region) && Objects.equals(country, that.country) && Objects.equals(timezone, that.timezone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, airportId, icao, iata, name, city, region, country, elevationFt, latitude, longitude, timezone);
    }

    @Override
    public String toString() {
        return "AirportDomain{" +
                "id='" + id + '\'' +
                ", airportId='" + airportId + '\'' +
                ", icao='" + icao + '\'' +
                ", iata='" + iata + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", country='" + country + '\'' +
                ", elevationFt=" + elevationFt +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", timezone='" + timezone + '\'' +
                '}';
    }
}