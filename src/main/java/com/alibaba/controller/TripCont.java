package com.alibaba.controller;


import com.alibaba.model.Trip;
import com.alibaba.service.ITripServ;
import com.alibaba.service.TripServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/trip")
public class TripCont {

    private final ITripServ serv;

    @Autowired
    public TripCont(TripServ serv) {
        this.serv = serv;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody @Valid Trip trip){
        try{
            serv.save(trip);
            return ResponseEntity.ok("creation successful");
        }catch (Exception e){ return ResponseEntity.status(503).body("data creation error");}
    }

}
