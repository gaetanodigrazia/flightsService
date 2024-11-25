package com.digrazia.FlightsService.integration.database.repository;

import com.digrazia.FlightsService.integration.database.entity.model.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<FlightEntity, String> {
}
