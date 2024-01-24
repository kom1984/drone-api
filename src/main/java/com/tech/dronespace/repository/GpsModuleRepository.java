package com.tech.dronespace.repository;

import com.tech.dronespace.model.GpsModuleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GpsModuleRepository extends JpaRepository<GpsModuleModel, Long> {
}
