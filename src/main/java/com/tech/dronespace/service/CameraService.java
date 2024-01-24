package com.tech.dronespace.service;

import com.tech.dronespace.model.CameraModel;
import com.tech.dronespace.repository.CameraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CameraService {
    @Autowired
    CameraRepository cameraRepository;
    public List<CameraModel> getCameras(){
        return cameraRepository.findAll();

    }

    //Save
    public CameraModel saveCamera(CameraModel cameraModel) {
        return cameraRepository.save(cameraModel);
    }

    //get a camera
    public CameraModel getCameraByid(Long id_camera) {
        return cameraRepository.findById(id_camera).get();
    }

    //Delete a camera
    public void deleteCamera(CameraModel cameraModel) {
        cameraRepository.delete(cameraModel);
    }

}
