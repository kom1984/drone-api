package com.tech.dronespace.controller;

import com.tech.dronespace.model.FlightControlModel;
import com.tech.dronespace.service.FlightControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping
@CrossOrigin("*")
public class FlightControlController {
    @Autowired
    FlightControlService flightControlService;

    @PostMapping("/flightControl")
    public FlightControlModel createFlightControl(@Validated @RequestBody(required = false) FlightControlModel flightControl) {
        return flightControlService.saveFlightControl(flightControl);
    }

    @GetMapping("/flightControls")
    public List<FlightControlModel> getAllFlightControls() {
        return flightControlService.getFlightControls();

    }

    @GetMapping("/flightControls/{idFlightControl}")
    public ResponseEntity findFlightControlByid(@PathVariable(name = "id_fc") Long id_fc) {

        if (id_fc == null) {
            return ResponseEntity.badRequest().body("Cannot retreive drone with null ID");
        }
        FlightControlModel flightControl = flightControlService.getFlightControlById(id_fc);
        if (flightControl == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(flightControl);
    }


    @DeleteMapping("/flightControls/{idFlightControl}")
    public ResponseEntity<FlightControlModel> deleteFlightControl(@Validated @PathVariable(name = "id_fc") Long id_fc) {


        FlightControlModel flightControl = flightControlService.getFlightControlById(id_fc);
        if (flightControl == null) {
            return ResponseEntity.notFound().build();
        }
        flightControlService.deleteFlightControl(flightControl);
        return ResponseEntity.ok().body(flightControl);
    }
}
