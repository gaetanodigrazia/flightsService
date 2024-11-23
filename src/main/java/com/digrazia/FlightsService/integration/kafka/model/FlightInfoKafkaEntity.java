package com.digrazia.FlightsService.integration.kafka.model;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FlightInfoKafkaEntity {

    private String icao24;
    private long firstSeen;
    private String estDepartureAirport;
    private long lastSeen;
    private String estArrivalAirport;
    private String callsign;
    private int estDepartureAirportHorizDistance;
    private int estDepartureAirportVertDistance;
    private int estArrivalAirportHorizDistance;
    private int estArrivalAirportVertDistance;
    private int departureAirportCandidatesCount;
    private int arrivalAirportCandidatesCount;
    private String type;

    public FlightInfoKafkaEntity() {}

    public String getIcao24() {
        return icao24;
    }

    @JsonProperty("icao24")
    public void setIcao24(String icao24) {
        this.icao24 = icao24;
    }

    public long getFirstSeen() {
        return firstSeen;
    }

    @JsonProperty("firstSeen")
    public void setFirstSeen(long firstSeen) {
        this.firstSeen = firstSeen;
    }

    public String getEstDepartureAirport() {
        return estDepartureAirport;
    }

    @JsonProperty("estDepartureAirport")
    public void setEstDepartureAirport(String estDepartureAirport) {
        this.estDepartureAirport = estDepartureAirport;
    }

    public long getLastSeen() {
        return lastSeen;
    }

    @JsonProperty("lastSeen")
    public void setLastSeen(long lastSeen) {
        this.lastSeen = lastSeen;
    }

    public String getEstArrivalAirport() {
        return estArrivalAirport;
    }

    @JsonProperty("estArrivalAirport")
    public void setEstArrivalAirport(String estArrivalAirport) {
        this.estArrivalAirport = estArrivalAirport;
    }

    public String getCallsign() {
        return callsign;
    }

    @JsonProperty("callsign")
    public void setCallsign(String callsign) {
        this.callsign = callsign;
    }

    public int getEstDepartureAirportHorizDistance() {
        return estDepartureAirportHorizDistance;
    }

    @JsonProperty("estDepartureAirportHorizDistance")
    public void setEstDepartureAirportHorizDistance(int estDepartureAirportHorizDistance) {
        this.estDepartureAirportHorizDistance = estDepartureAirportHorizDistance;
    }

    public int getEstDepartureAirportVertDistance() {
        return estDepartureAirportVertDistance;
    }

    @JsonProperty("estDepartureAirportVertDistance")
    public void setEstDepartureAirportVertDistance(int estDepartureAirportVertDistance) {
        this.estDepartureAirportVertDistance = estDepartureAirportVertDistance;
    }

    public int getEstArrivalAirportHorizDistance() {
        return estArrivalAirportHorizDistance;
    }

    @JsonProperty("estArrivalAirportHorizDistance")
    public void setEstArrivalAirportHorizDistance(int estArrivalAirportHorizDistance) {
        this.estArrivalAirportHorizDistance = estArrivalAirportHorizDistance;
    }

    public int getEstArrivalAirportVertDistance() {
        return estArrivalAirportVertDistance;
    }

    @JsonProperty("estArrivalAirportVertDistance")
    public void setEstArrivalAirportVertDistance(int estArrivalAirportVertDistance) {
        this.estArrivalAirportVertDistance = estArrivalAirportVertDistance;
    }

    public int getDepartureAirportCandidatesCount() {
        return departureAirportCandidatesCount;
    }

    @JsonProperty("departureAirportCandidatesCount")
    public void setDepartureAirportCandidatesCount(int departureAirportCandidatesCount) {
        this.departureAirportCandidatesCount = departureAirportCandidatesCount;
    }

    public int getArrivalAirportCandidatesCount() {
        return arrivalAirportCandidatesCount;
    }

    @JsonProperty("arrivalAirportCandidatesCount")
    public void setArrivalAirportCandidatesCount(int arrivalAirportCandidatesCount) {
        this.arrivalAirportCandidatesCount = arrivalAirportCandidatesCount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "FlightInfoKafkaEntity{" +
                "icao24='" + icao24 + '\'' +
                ", firstSeen=" + firstSeen +
                ", estDepartureAirport='" + estDepartureAirport + '\'' +
                ", lastSeen=" + lastSeen +
                ", estArrivalAirport='" + estArrivalAirport + '\'' +
                ", callsign='" + callsign + '\'' +
                ", estDepartureAirportHorizDistance=" + estDepartureAirportHorizDistance +
                ", estDepartureAirportVertDistance=" + estDepartureAirportVertDistance +
                ", estArrivalAirportHorizDistance=" + estArrivalAirportHorizDistance +
                ", estArrivalAirportVertDistance=" + estArrivalAirportVertDistance +
                ", departureAirportCandidatesCount=" + departureAirportCandidatesCount +
                ", arrivalAirportCandidatesCount=" + arrivalAirportCandidatesCount +
                ", type='" + type + '\'' +
                '}';
    }
}

