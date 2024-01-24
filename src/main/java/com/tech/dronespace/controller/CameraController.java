package com.tech.dronespace.controller;

import com.tech.dronespace.model.CameraModel;
import com.tech.dronespace.service.CameraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping
@CrossOrigin("*")
public class CameraController {
    @Autowired
    CameraService cameraService;

    @PostMapping("/camera")
    public CameraModel createCamera(@Validated @RequestBody(required = false) CameraModel cameraModel) {
        return cameraService.saveCamera(cameraModel);
    }

    @GetMapping("/cameras")
    public List<CameraModel> getAllCameras(){
        return cameraService.getCameras();

    }

    @GetMapping("/cameras/{idCamera}")
    public ResponseEntity findCameraByid(@PathVariable(name="idCamera") Long idCamera) {

        if(idCamera == null) {
            return ResponseEntity.badRequest().body("Cannot retreive véhicule with null ID");
        }
        CameraModel cameraModel = cameraService.getCameraByid(idCamera);
        if(cameraModel==null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(cameraModel);
    }


    @DeleteMapping("/cameras/{idCamera}")
    public ResponseEntity<CameraModel> deleteCamera(@Validated @PathVariable(name="idCamera") Long idCamera) {


        CameraModel cameraModel = cameraService.getCameraByid(idCamera);
        if(cameraModel==null) {
            return ResponseEntity.notFound().build();
        }
        cameraService.deleteCamera(cameraModel);
        return ResponseEntity.ok().body(cameraModel);
    }

}
