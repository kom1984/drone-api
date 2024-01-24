package com.tech.dronespace.controller;

import com.tech.dronespace.model.GpsModuleModel;
import com.tech.dronespace.service.GpsModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping
@CrossOrigin("*")
public class GpsModuleController {
    @Autowired
    GpsModuleService gpsModuleService;

    @PostMapping("/gpsModule")
    public GpsModuleModel createGpsModule(@Validated @RequestBody(required = false) GpsModuleModel gpsModule) {
        return gpsModuleService.saveGpsModule(gpsModule);
    }

    @GetMapping("/gpsModules")
    public List<GpsModuleModel> getAllGpsModules(){
        return gpsModuleService.getGpsModules();

    }

    @GetMapping("/gpsModules/{id_gps}")
    public ResponseEntity findGpsModuleById(@PathVariable(name="id_gps") Long id_gps) {

        if(id_gps == null) {
            return ResponseEntity.badRequest().body("Cannot retreive gpsModule with null ID");
        }
        GpsModuleModel gpsModule = gpsModuleService.getGpsModuleById(id_gps);
        if(gpsModule==null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(gpsModule);
    }


    @DeleteMapping("/gpsModules/{id_gps}")
    public ResponseEntity<GpsModuleModel> deleteGpsModule(@Validated @PathVariable(name="id_gps") Long id_gps ){


        GpsModuleModel gpsModule = gpsModuleService.getGpsModuleById(id_gps);
        if(gpsModule==null) {
            return ResponseEntity.notFound().build();
        }
        gpsModuleService.deleteGpsModule(gpsModule);
        return ResponseEntity.ok().body(gpsModule);
    }
}
