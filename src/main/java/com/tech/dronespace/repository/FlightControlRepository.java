package com.tech.dronespace.repository;

import com.tech.dronespace.model.FlightControlModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightControlRepository extends JpaRepository<FlightControlModel, Long> {
}
