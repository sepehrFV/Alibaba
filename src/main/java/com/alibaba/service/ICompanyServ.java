package com.alibaba.service;

import com.alibaba.model.Company;
import com.alibaba.model.Vehicle;

import java.util.List;

public interface ICompanyServ extends GenericService<Company,Long>{
    Company findByName(String name);
    List<Vehicle> findVehiclesByCompanyId(Long id);
    List<Vehicle> findVehiclesByCompanyName(String name);

}
