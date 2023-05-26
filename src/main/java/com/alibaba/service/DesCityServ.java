package com.alibaba.service;

import com.alibaba.model.DesCity;
import com.alibaba.repository.DesCityRepo;
import com.alibaba.repository.GenericRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DesCityServ extends GenericServiceImp<DesCity,Long> implements IDesCityServ {

    private final DesCityRepo repo;

    @Autowired
    public DesCityServ(DesCityRepo repo) {
        this.repo = repo;
    }

    @Override
    protected GenericRepo<DesCity, Long> getRepo() {
        return this.repo;
    }


}
