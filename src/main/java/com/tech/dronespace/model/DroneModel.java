package com.tech.dronespace.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Entity
@Table(name="DRONE")
public class DroneModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_DRONE")
    private Long id_drone;

    @Column(name="MODEL")
    private String model;

    @Column(name="POID")
    private double poid;

    @Column(name="MAX_RANGE")
    private double max_range;

    @Column(name="BATTERY_CAPACITY")
    private int battery_capacity;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_camera")
    private CameraModel cameraModel;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_gps")
    private GpsModuleModel gpsModuleModel;
}
