package com.digrazia.FlightsService.integration.kafka.consumer;

import com.digrazia.FlightsService.integration.model.AirportEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "airports", groupId = "group_id", containerFactory = "kafkaListenerContainerFactory")
    public void listenGroupFoo(AirportEntity airportEntity) {
        System.out.println("Received Message in group foo: " + airportEntity);
    }
}