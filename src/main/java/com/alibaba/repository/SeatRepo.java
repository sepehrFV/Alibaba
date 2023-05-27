package com.alibaba.repository;

import com.alibaba.model.Seat;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepo extends GenericRepo<Seat,Long> {

}
