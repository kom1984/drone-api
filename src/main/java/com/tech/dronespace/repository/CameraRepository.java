package com.tech.dronespace.repository;

import com.tech.dronespace.model.CameraModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CameraRepository extends JpaRepository<CameraModel,Long> {
}
