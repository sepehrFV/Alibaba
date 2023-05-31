package com.alibaba.controller;

import com.alibaba.model.Vehicle;
import com.alibaba.service.IVehicleServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/vehicle")
public class VehicleCont {

    private final IVehicleServ serv;

    @Autowired
    public VehicleCont(IVehicleServ serv) {
        this.serv = serv;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody @Valid Vehicle vehicle){
        try{
            serv.save(vehicle);
            return ResponseEntity.ok("creation successful");
        }catch (Exception e){ return ResponseEntity.status(503).body("data creation error");}
    }

}
