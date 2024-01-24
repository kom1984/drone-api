package com.tech.dronespace.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
@Entity
@Table(name="FLIGHT-CONTROLLER")
public class FlightControlModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_FC")
    private Long id_fc;

    @Column(name="CURRENT_SPEED")
    private double current_speed;

    @Column(name="TARGET_ALTITUDE")
    private double target_altitude;

    @Column(name="TARGET_POSITION")
    private double target_position;

    @OneToMany(mappedBy="flightControllerModel")
    @JsonIgnore
    private List<GpsModuleModel> gpsModuleModelList;
}
