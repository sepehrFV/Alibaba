package com.alibaba.controller;

import com.alibaba.model.Company;
import com.alibaba.repository.CompanyRepo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyCont {

    private final CompanyRepo service;


    @Autowired
    public CompanyCont(CompanyRepo service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<String> create(@RequestBody @Valid Company company) {
        service.save(company);
        return ResponseEntity.ok("Company "+company.getName() +" successfully created");
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<List<Company>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/findByName")
    public ResponseEntity<Company> findByName(@RequestParam String name){
        return ResponseEntity.ok(service.findCompanyByName(name));
    }





}
