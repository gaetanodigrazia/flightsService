package com.digrazia.FlightsService.integration.database.repository;

import com.digrazia.FlightsService.integration.database.entity.model.AirportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AirportRepository extends JpaRepository<AirportEntity, String> {
    Optional<AirportEntity> findByIcao(String icao);
}
