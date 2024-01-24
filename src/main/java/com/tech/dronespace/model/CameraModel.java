package com.tech.dronespace.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
@Entity
@Table(name="camera")
public class CameraModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="IDCAMERA")
    private Long id_camera;
    @Column(name="RESOLUTION")
    private String resolution;
    @Column(name="ZOOM")
    private Double zoom;
    @OneToOne(mappedBy = "cameraModel")
    private DroneModel droneModel;
}
