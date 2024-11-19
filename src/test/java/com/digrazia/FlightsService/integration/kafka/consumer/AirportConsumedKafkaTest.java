package com.digrazia.FlightsService.integration.kafka.consumer;


import com.digrazia.FlightsService.integration.database.entity.model.AirportEntity;
import com.digrazia.FlightsService.integration.database.repository.AirportRepository;
import com.digrazia.FlightsService.integration.kafka.model.AirportKafkaEntity;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.TestPropertySource;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@SpringBootTest
@TestPropertySource(
        properties = {
                "spring.kafka.consumer.auto-offset-reset=earliest",
                "spring.datasource.url=jdbc:tc:mysql:8.0.32:///db",
        }
)
@Testcontainers
class AirportConsumedKafkaTest {

    @Container
    static final KafkaContainer kafka = new KafkaContainer(
            DockerImageName.parse("confluentinc/cp-kafka:7.6.1")
    );

    @DynamicPropertySource
    static void overrideProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.kafka.bootstrap-servers", kafka::getBootstrapServers);
    }

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    private AirportRepository airportRepository;

    @BeforeEach
    void setUp() {

    }

    @Test
    void shouldHandleProductPriceChangedEvent() {
        AirportEntity airportKafkaEntity = new AirportEntity();
        airportKafkaEntity.setIcao("sampleIcaoBis");
        airportKafkaEntity.setIata("sampleIataBis");
        airportKafkaEntity.setCountry("sampleCountryBis");

        kafkaTemplate.send("groupd_id", airportKafkaEntity.getIcao(), airportKafkaEntity);

        await()
                .pollInterval(Duration.ofSeconds(3))
                .atMost(10, SECONDS)
                .untilAsserted(() -> {
                    Optional<AirportEntity> maybeAirport = airportRepository.findByIcao(airportKafkaEntity.getIcao());
                    assertThat(maybeAirport).isPresent();
                    AirportEntity actualAirport = maybeAirport.get();
                    assertThat(actualAirport.getIcao()).isEqualTo(airportKafkaEntity.getIcao());
                });
    }
}