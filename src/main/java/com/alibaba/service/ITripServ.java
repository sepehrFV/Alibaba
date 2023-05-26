package com.alibaba.service;

import com.alibaba.embeddable.LocationPoint;
import com.alibaba.model.Trip;

import java.util.Date;

public interface ITripServ extends GenericService<Trip,Long>{

    Double calculateDistance(LocationPoint originTown,LocationPoint destinationTown);
    Integer calculateTripTime(Double distance);
    Date calculateArriveTime(Integer tripTime,Date departAt);
    Double calculatePrice(Double distance);
    void expiredCheck(Date departTime);


}
