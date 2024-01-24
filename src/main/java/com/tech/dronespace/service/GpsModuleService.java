package com.tech.dronespace.service;

import com.tech.dronespace.model.GpsModuleModel;
import com.tech.dronespace.repository.GpsModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GpsModuleService{
    @Autowired
    GpsModuleRepository gpsModuleRepository;

    //Liste de gpsModule
    public List<GpsModuleModel> getGpsModules(){
        return gpsModuleRepository.findAll();

    }

    //Save
    public GpsModuleModel saveGpsModule(GpsModuleModel gpsModule) {
        return gpsModuleRepository.save(gpsModule);
    }

    //get a gpsModule
    public GpsModuleModel getGpsModuleById(Long id_gps) {
        return gpsModuleRepository.findById(id_gps).get();
    }

    //Delete a gpsModule
    public void deleteGpsModule(GpsModuleModel gpsModule) {
        gpsModuleRepository.delete(gpsModule);
    }
}
