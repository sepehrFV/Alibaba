package com.alibaba.controller;

import com.alibaba.model.Bus;
import com.alibaba.model.DesCity;
import com.alibaba.service.IDesCityServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/descity")
public class DesCityCont {

    private final IDesCityServ serv;


    @Autowired
    public DesCityCont(IDesCityServ serv) {
        this.serv = serv;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody DesCity desCity){
        try{
            serv.save(desCity);
            return ResponseEntity.ok("creation successful");
        }catch (Exception e){ return ResponseEntity.status(503).body("data creation error");}
    }

}
