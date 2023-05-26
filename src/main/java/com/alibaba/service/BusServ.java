package com.alibaba.service;

import com.alibaba.model.Bus;
import com.alibaba.repository.BusRepo;
import com.alibaba.repository.GenericRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusServ extends GenericServiceImp<Bus,Long> implements IBusServ{

    private final BusRepo repo;

    @Autowired
    public BusServ(BusRepo repo) {
        this.repo = repo;
    }

    @Override
    protected GenericRepo<Bus, Long> getRepo() {
        return this.repo;
    }
}
