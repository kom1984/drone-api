package com.tech.dronespace.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Entity
@Table(name="GPS-MODULE")
public class GpsModuleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_GPS")
    private Long id_gps;

    @Column(name="LATITUDE")
    private double latitude;

    @Column(name="LONGITUDE")
    private double longitude;

    @Column(name="ALTITUDE")
    private double altitude;

    @OneToOne(mappedBy = "gpsModuleModel")
    private DroneModel droneModel;

    @ManyToOne
    @JoinColumn(name="id_flightController")
    @JsonIgnore
    private FlightControlModel flightControllerModel;
}
