package com.digrazia.FlightsService.integration.kafka.consumer;

import com.digrazia.FlightsService.business.mapper.entity.AirportEntityMapper;
import com.digrazia.FlightsService.integration.database.entity.model.AirportEntity;
import com.digrazia.FlightsService.integration.database.repository.AirportRepository;
import com.digrazia.FlightsService.integration.kafka.model.AirportKafkaEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);
    @Autowired
    private AirportRepository airportRepository;

    @Autowired
    private AirportEntityMapper airportEntityMapper;

    private final String groupId = "group_id";

    @KafkaListener(topics = "airports", groupId = groupId, containerFactory = "kafkaListenerContainerFactory")
    public void listenForAirportEntity(AirportKafkaEntity airportKafkaEntity) {
        String message = airportKafkaEntity.toString();
        String log = String.format("Received airport: %s in groupId %s", message, groupId);
        logger.info(log);
        saveOrUpdateEntity(airportKafkaEntity);
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
}