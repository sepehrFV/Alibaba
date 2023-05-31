package com.alibaba.controller;

import com.alibaba.model.User;
import com.alibaba.service.IUserServ;
import com.alibaba.service.UserServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserCont {

    private final IUserServ serv;

    @Autowired
    public UserCont(UserServ serv) {
        this.serv = serv;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody @Valid User user){
        try{
            serv.save(user);
            return ResponseEntity.ok("creation successful");
        }catch (Exception e){ return ResponseEntity.status(503).body("data creation error");}
    }

}
