package com.tech.dronespace.repository;

import com.tech.dronespace.model.DroneModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DroneRepository extends JpaRepository<DroneModel, Long> {
}
