package com.digrazia.FlightsService.integration.kafka.consumer;

import com.digrazia.FlightsService.integration.kafka.model.AirportKafkaEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "airports", groupId = "group_id", containerFactory = "kafkaListenerContainerFactory")
    public void listenGroupFoo(AirportKafkaEntity airportKafkaEntity) {
        System.out.println("Received Message in group foo: " + airportKafkaEntity);
    }
}