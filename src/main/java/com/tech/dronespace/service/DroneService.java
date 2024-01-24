package com.tech.dronespace.service;

import com.tech.dronespace.model.DroneModel;
import com.tech.dronespace.repository.DroneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DroneService {
    @Autowired
    DroneRepository droneRepository;

    //Liste de drone
    public List<DroneModel> getDrones(){
        return droneRepository.findAll();

    }

    //Save
    public DroneModel saveDrone(DroneModel drone) {
        return droneRepository.save(drone);
    }

    //get a drone
    public DroneModel getDroneById(Long id_drone) {
        return droneRepository.findById(id_drone).get();
    }

    //Delete a drone
    public void deleteDrone(DroneModel drone) {
        droneRepository.delete(drone);
    }

}
