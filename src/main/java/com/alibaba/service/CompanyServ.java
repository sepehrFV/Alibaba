package com.alibaba.service;

import com.alibaba.model.Company;
import com.alibaba.model.Vehicle;
import com.alibaba.repository.CompanyRepo;
import com.alibaba.repository.GenericRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServ extends GenericServiceImp<Company,Long> implements ICompanyServ{


    private final CompanyRepo repo;

    @Autowired
    public CompanyServ(CompanyRepo repo) {
        this.repo = repo;
    }

    @Override
    protected GenericRepo<Company, Long> getRepo() {
        return this.repo;
    }

    @Override
    protected Class<?> getExtendedClass() {
        return this.getClass();
    }


    @Override
    public Company findByName(String name) {
        return repo.findCompanyByName(name);
    }

    @Override
    public List<Vehicle> findVehiclesByCompanyId(Long id) {
        return repo.findVehiclesByCompanyId(id);
    }

    @Override
    public List<Vehicle> findVehiclesByCompanyName(String name) {
        return repo.findVehiclesByCompanyName(name);
    }


}
