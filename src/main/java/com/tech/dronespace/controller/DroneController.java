package com.tech.dronespace.controller;

import com.tech.dronespace.model.DroneModel;
import com.tech.dronespace.service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin("*")
public class DroneController {
    @Autowired
    DroneService droneService;

    @PostMapping("/drone")
    public DroneModel createDrone(@Validated @RequestBody(required = false) DroneModel drone) {
        return droneService.saveDrone(drone);
    }

    @GetMapping("/drones")
    public List<DroneModel> getAllDrones(){
        return droneService.getDrones();

    }

    @GetMapping("/drones/{id_drone}")
    public ResponseEntity findDroneByid(@PathVariable(name="id_drone") Long id_drone) {

        if(id_drone == null) {
            return ResponseEntity.badRequest().body("Cannot retreive drone with null ID");
        }
        DroneModel drone = droneService.getDroneById(id_drone);
        if(drone==null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(drone);
    }


    @DeleteMapping("/drones/{id_drone}")
    public ResponseEntity<DroneModel> deleteDrone(@Validated @PathVariable(name="id_drone") Long id_drone ){


        DroneModel drone = droneService.getDroneById(id_drone);
        if(drone==null) {
            return ResponseEntity.notFound().build();
        }
        droneService.deleteDrone(drone);
        return ResponseEntity.ok().body(drone);
    }
}
