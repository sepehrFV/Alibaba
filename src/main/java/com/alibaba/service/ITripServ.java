package com.alibaba.service;

import com.alibaba.enums.DesCity;
import com.alibaba.model.Trip;

import java.util.Date;

public interface ITripServ extends GenericService<Trip,Long>{

    Double calculateDistance(DesCity originTown, DesCity destinationTown);
    Integer calculateTripTime(Double distance,Integer averageSpeed);
    Date calculateArriveTime(Integer tripTime,Date departAt);
    Double calculatePrice(Double distance,Double priceRatio);
    void expiredCheck(Date departTime);


}
