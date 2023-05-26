package com.alibaba.service;

import com.alibaba.model.Bus;
import com.alibaba.model.Company;
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
    public Company findByName(String name) {
        return repo.findCompanyByName(name);
    }

    @Override
    public List<Bus> findBusesByCompanyId(Long id) {
        return repo.findBusesByCompanyId(id);
    }

    @Override
    public List<Bus> findBusesByCompanyName(String name) {
        return repo.findBusesByCompanyName(name);
    }


}
