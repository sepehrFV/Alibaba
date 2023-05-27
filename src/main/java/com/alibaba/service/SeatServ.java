package com.alibaba.service;

import com.alibaba.model.Seat;
import com.alibaba.repository.GenericRepo;
import org.springframework.stereotype.Service;

@Service
public class SeatServ extends GenericServiceImp<Seat,Long> implements ISeatServ {
    @Override
    protected GenericRepo<Seat, Long> getRepo() {
        return null;
    }
}
