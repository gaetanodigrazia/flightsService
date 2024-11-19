package com.digrazia.FlightsService.integration.kafka.consumer;

import com.digrazia.FlightsService.integration.kafka.model.AirportKafkaEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    private final String groupId = "group_id";
    @KafkaListener(topics = "airports", groupId = groupId, containerFactory = "kafkaListenerContainerFactory")
    public void listenForAirportEntity(AirportKafkaEntity airportKafkaEntity) {
        String message = airportKafkaEntity.toString();
        String log = String.format("Received airport: %s in groupId %s", message, groupId);
        logger.info(log);
    }
}