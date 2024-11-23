package com.digrazia.FlightsService.integration.kafka.consumer;

import com.digrazia.FlightsService.business.mapper.entity.AirportEntityMapper;
import com.digrazia.FlightsService.integration.database.entity.model.AirportEntity;
import com.digrazia.FlightsService.integration.database.entity.model.FlightEntity;
import com.digrazia.FlightsService.integration.database.mapper.FlightEntityMapper;
import com.digrazia.FlightsService.integration.database.repository.AirportRepository;
import com.digrazia.FlightsService.integration.database.repository.FlightRepository;
import com.digrazia.FlightsService.integration.kafka.model.AirportKafkaEntity;
import com.digrazia.FlightsService.integration.kafka.model.FlightInfoKafkaEntity;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KafkaConsumer {
    Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);
    @Autowired
    private AirportRepository airportRepository;

    @Autowired
    private AirportEntityMapper airportEntityMapper;
    @Autowired
    FlightEntityMapper flightEntityMapper;
    @Autowired
    FlightRepository flightRepository;


    private final String groupId = "group_id";

    @KafkaListener(topics = "departures", groupId = groupId, containerFactory = "flightsKafkaListenerContainerFactory")
    public void consumeDeparture(String message) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String jsonArray = objectMapper.readValue(message, String.class);

            List<FlightInfoKafkaEntity> flightInfoList = objectMapper.readValue(
                    jsonArray,
                    new TypeReference<List<FlightInfoKafkaEntity>>() {}
            );
            flightInfoList.stream().forEach(flightInfo -> {flightInfo.setType("DEPARTURE");});
            saveDeparture(flightInfoList);
        } catch (Exception e) {
            System.err.println("Error deserializing message: " + e.getMessage());
            System.err.println(message);
        }
    }

    @KafkaListener(topics = "arrivals", groupId = groupId, containerFactory = "flightsKafkaListenerContainerFactory")
    public void consumeArrival(String message) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            String jsonArray = objectMapper.readValue(message, String.class);

            List<FlightInfoKafkaEntity> flightInfoList = objectMapper.readValue(
                    jsonArray,
                    new TypeReference<List<FlightInfoKafkaEntity>>() {});
                    flightInfoList.stream().forEach(flightInfo -> {flightInfo.setType("ARRIVAL");});

            saveArrival(flightInfoList);
        } catch (Exception e) {
            System.err.println("Error deserializing message: " + e.getMessage());
        }
    }

    @KafkaListener(topics = "airports", groupId = groupId, containerFactory = "airportKafkaListenerContainerFactory")
    public void listenForAirportEntity(String message) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String airportMessage = objectMapper.readValue(message, String.class);

            AirportKafkaEntity airportKafkaEntity = objectMapper.readValue(airportMessage, AirportKafkaEntity.class);
            saveOrUpdateEntity(airportKafkaEntity);
        } catch (Exception e) {
            System.err.println("Error deserializing message: " + e.getMessage());
        }

    }

    private void saveOrUpdateEntity(AirportKafkaEntity airportKafkaEntity){
        AirportEntity airportEntity = airportEntityMapper.fromKafkaEntityToEntity(airportKafkaEntity);
        airportRepository.findByIcao(airportEntity.getIcao())
                .ifPresentOrElse(foundAirport -> {
                    if (!airportEntity.toString().equals(foundAirport.toString())) {
                        airportRepository.delete(foundAirport);
                        airportRepository.save(airportEntity);
                    }}, () -> airportRepository.save(airportEntity));
    }

    private void saveDeparture(List<FlightInfoKafkaEntity> flightInfoEntityList){
        flightInfoEntityList
                .stream()
                .forEach(departureKafkaEntity -> {
                    FlightEntity flightEntity = flightEntityMapper.fromKafkaEntityToEntity(departureKafkaEntity);
                    logger.info("Consumed: " + flightEntity.toString());
                    //flightRepository.save(flightEntity);
                });
    }

    private void saveArrival(List<FlightInfoKafkaEntity> flightInfoEntityList){
        flightInfoEntityList
                .stream()
                .forEach(departureKafkaEntity -> {
                    FlightEntity flightEntity = flightEntityMapper.fromKafkaEntityToEntity(departureKafkaEntity);
                    //flightRepository.save(flightEntity);
                });
    }

}