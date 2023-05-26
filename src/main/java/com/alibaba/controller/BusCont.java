package com.alibaba.controller;

import com.alibaba.model.Bus;
import com.alibaba.service.IBusServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/bus")
public class BusCont {

    private final IBusServ serv;

    @Autowired
    public BusCont(IBusServ serv) {
        this.serv = serv;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Bus bus){
        try{
            serv.save(bus);
            return ResponseEntity.ok("creation successful");
        }catch (Exception e){ return ResponseEntity.status(503).body("data creation error");}
    }

}
