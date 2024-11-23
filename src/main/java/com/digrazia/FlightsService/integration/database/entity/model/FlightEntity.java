package com.digrazia.FlightsService.integration.database.entity.model;

import jakarta.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "flight")
public class FlightEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "flight_id", length = 255, nullable = false)
    private String flightInfoId;

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

    public String getFlightInfoId() {
        return flightInfoId;
    }

    public void setFlightInfoId(String flightInfoId) {
        this.flightInfoId = flightInfoId;
    }

    public String getIcao24() {
        return icao24;
    }

    public void setIcao24(String icao24) {
        this.icao24 = icao24;
    }

    public long getFirstSeen() {
        return firstSeen;
    }

    public void setFirstSeen(long firstSeen) {
        this.firstSeen = firstSeen;
    }

    public String getEstDepartureAirport() {
        return estDepartureAirport;
    }

    public void setEstDepartureAirport(String estDepartureAirport) {
        this.estDepartureAirport = estDepartureAirport;
    }

    public long getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(long lastSeen) {
        this.lastSeen = lastSeen;
    }

    public String getEstArrivalAirport() {
        return estArrivalAirport;
    }

    public void setEstArrivalAirport(String estArrivalAirport) {
        this.estArrivalAirport = estArrivalAirport;
    }

    public String getCallsign() {
        return callsign;
    }

    public void setCallsign(String callsign) {
        this.callsign = callsign;
    }

    public int getEstDepartureAirportHorizDistance() {
        return estDepartureAirportHorizDistance;
    }

    public void setEstDepartureAirportHorizDistance(int estDepartureAirportHorizDistance) {
        this.estDepartureAirportHorizDistance = estDepartureAirportHorizDistance;
    }

    public int getEstDepartureAirportVertDistance() {
        return estDepartureAirportVertDistance;
    }

    public void setEstDepartureAirportVertDistance(int estDepartureAirportVertDistance) {
        this.estDepartureAirportVertDistance = estDepartureAirportVertDistance;
    }

    public int getEstArrivalAirportHorizDistance() {
        return estArrivalAirportHorizDistance;
    }

    public void setEstArrivalAirportHorizDistance(int estArrivalAirportHorizDistance) {
        this.estArrivalAirportHorizDistance = estArrivalAirportHorizDistance;
    }

    public int getEstArrivalAirportVertDistance() {
        return estArrivalAirportVertDistance;
    }

    public void setEstArrivalAirportVertDistance(int estArrivalAirportVertDistance) {
        this.estArrivalAirportVertDistance = estArrivalAirportVertDistance;
    }

    public int getDepartureAirportCandidatesCount() {
        return departureAirportCandidatesCount;
    }

    public void setDepartureAirportCandidatesCount(int departureAirportCandidatesCount) {
        this.departureAirportCandidatesCount = departureAirportCandidatesCount;
    }

    public int getArrivalAirportCandidatesCount() {
        return arrivalAirportCandidatesCount;
    }

    public void setArrivalAirportCandidatesCount(int arrivalAirportCandidatesCount) {
        this.arrivalAirportCandidatesCount = arrivalAirportCandidatesCount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    @PrePersist
    public void generateUUID() {
        if (this.flightInfoId == null) {
            this.flightInfoId = UUID.randomUUID().toString();
        }
    }
    @Override
    public String toString() {
        return "FlightEntity{" +
                "flightInfoId='" + flightInfoId + '\'' +
                ", icao24='" + icao24 + '\'' +
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
