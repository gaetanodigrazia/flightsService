CREATE DATABASE IF NOT EXISTS flightService;

USE flightService;

-- Creazione della tabella airport
CREATE TABLE IF NOT EXISTS airport (
                                       airport_id VARCHAR(255) NOT NULL,
                                       icao VARCHAR(255) NOT NULL UNIQUE,
                                       iata VARCHAR(255),
                                       name VARCHAR(255) NOT NULL,
                                       city VARCHAR(255) NOT NULL,
                                       region VARCHAR(255) NOT NULL,
                                       country VARCHAR(255) NOT NULL,
                                       elevation_ft INT NOT NULL,
                                       latitude DOUBLE NOT NULL,
                                       longitude DOUBLE NOT NULL,
                                       timezone VARCHAR(255) NOT NULL,
                                       PRIMARY KEY (airport_id)
);

-- Inserimento dati di esempio nella tabella Airport
INSERT INTO airport (airport_id, icao, iata, name, city, region, country, elevation_ft, latitude, longitude, timezone)
VALUES
    ('00000000-0000-0000-0000-000000000001', 'ABCD', 'XYZ', 'Test Airport', 'Test City', 'Test Region', 'Test Country', 1000, 40.7128, -74.0060, 'UTC'),
    ('00000000-0000-0000-0000-000000000002', 'EFGH', 'XYZ', 'Another Airport', 'Test City', 'Test Region', 'Test Country', 1500, 41.7128, -75.0060, 'UTC');

-- Creazione della tabella flight
CREATE TABLE IF NOT EXISTS flight (
                                      flight_id VARCHAR(255) NOT NULL,
                                      icao24 VARCHAR(255),
                                      first_seen BIGINT NOT NULL,
                                      est_departure_airport VARCHAR(255),
                                      last_seen BIGINT NOT NULL,
                                      est_arrival_airport VARCHAR(255),
                                      callsign VARCHAR(255),
                                      est_departure_airport_horiz_distance INT NOT NULL,
                                      est_departure_airport_vert_distance INT NOT NULL,
                                      est_arrival_airport_horiz_distance INT NOT NULL,
                                      est_arrival_airport_vert_distance INT NOT NULL,
                                      departure_airport_candidates_count INT NOT NULL,
                                      arrival_airport_candidates_count INT NOT NULL,
                                      type VARCHAR(50),  -- Il campo 'type' come stringa
                                      PRIMARY KEY (flight_id),
                                      CONSTRAINT FK_airport_icao FOREIGN KEY (est_departure_airport) REFERENCES airport(icao) ON DELETE NO ACTION,
                                      CONSTRAINT FK_est_arrival_airport FOREIGN KEY (est_arrival_airport) REFERENCES airport(icao) ON DELETE NO ACTION
);

-- Inserimento dati di esempio nella tabella Flight
INSERT INTO flight (
    flight_id, icao24, first_seen, est_departure_airport, last_seen, est_arrival_airport, callsign,
    est_departure_airport_horiz_distance, est_departure_airport_vert_distance, est_arrival_airport_horiz_distance,
    est_arrival_airport_vert_distance, departure_airport_candidates_count, arrival_airport_candidates_count, type
) VALUES
    ('F12345ABC', 'ABC123', 1638220000, 'ABCD', 1638223600, 'EFGH', 'ABC123', 1500, 300, 2000, 350, 3, 2, 'departure');

-- Creazione della tabella user
CREATE TABLE IF NOT EXISTS user (
                                    user_id VARCHAR(255) PRIMARY KEY,
                                    first_name VARCHAR(50) NOT NULL,
                                    last_name VARCHAR(50) NOT NULL,
                                    email VARCHAR(100) NOT NULL UNIQUE,
                                    password VARCHAR(255) NOT NULL,
                                    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Inserimento dati di esempio nella tabella User
INSERT INTO user (user_id, first_name, last_name, email, password)
VALUES
    ('00000000-0000-0000-0000-000000000003', 'John', 'Doe', 'johndoe@example.com', 'password123');
