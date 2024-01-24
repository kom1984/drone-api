package com.tech.dronespace.service;

import com.tech.dronespace.model.FlightControlModel;
import com.tech.dronespace.repository.FlightControlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FlightControlService {
    @Autowired
    FlightControlRepository flightControlRepository;

    //Liste de flightControl
    public List<FlightControlModel> getFlightControls(){
        return flightControlRepository.findAll();

    }

    //Save
    public FlightControlModel saveFlightControl(FlightControlModel flightControl) {
        return flightControlRepository.save(flightControl);
    }

    //get a flightControl
    public FlightControlModel getFlightControlById(Long id_fc) {
        return flightControlRepository.findById(id_fc).get();
    }

    //Delete a flightControl
    public void deleteFlightControl(FlightControlModel flightControl) {
        flightControlRepository.delete(flightControl);
    }

}
