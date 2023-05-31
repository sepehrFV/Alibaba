package com.alibaba.service;


import com.alibaba.enums.DesCity;
import com.alibaba.model.Trip;
import com.alibaba.model.Vehicle;
import com.alibaba.repository.GenericRepo;
import com.alibaba.repository.TripRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class TripServ extends GenericServiceImp<Trip, Long> implements ITripServ {

    private final TripRepo repo;
    private final IVehicleServ vehicleServ;

    @Autowired
    public TripServ(TripRepo repo, IVehicleServ vehicleServ) {
        this.repo = repo;
        this.vehicleServ = vehicleServ;
    }


    @Override
    protected GenericRepo<Trip, Long> getRepo() {
        return repo;
    }

    @Override
    protected Class<?> getExtendedClass() {
        return this.getClass();
    }

    @Override
    public Double calculateDistance(DesCity originTown, DesCity destinationTown) {
        logger.debug("enter trip calculateDistance()");
        Double distance = null;
        try {
            final int r = 6371;//radius of earth
            double latDistance = Math.toRadians(originTown.latitude - destinationTown.latitude);
            double lonDistance = Math.toRadians(originTown.longitude - destinationTown.longitude);
            double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                    + Math.cos(Math.toRadians(destinationTown.latitude)) * Math.cos(destinationTown.latitude)
                    * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
            double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(Math.abs(1 - a)));
            distance = r * c;//km
        }catch (ArithmeticException ex){
            logger.error(ex.getMessage());
            ex.printStackTrace();
        }
        return distance;

    }


    @Override
    public Integer calculateTripTime(Double distance,Integer averageSpeed) {
        return (Integer) (int) (distance / averageSpeed);
    }

    @Override
    public Date calculateArriveTime(Integer tripTime, Date departAt) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(departAt);
        calendar.add(Calendar.HOUR_OF_DAY, tripTime);
        return calendar.getTime();
    }

    @Override
    public Double calculatePrice(Double distance,Double priceRatio) {
        final Double pricePerEachKm = 0.3;
        Double specificVehicleTypePrice = pricePerEachKm * priceRatio;
        return (distance * specificVehicleTypePrice);
    }

    @Override
    public void expiredCheck(Date departTime) {
        repo.findAll().forEach(t -> {
            Date currentDate = new Date();
            if (currentDate.after(t.getDepartAt())) t.setExpired(true);
        });
    }


    @Override
    public void save(Trip trip) {

        logger.debug("enter trip's save()...");
        Vehicle vehicle = vehicleServ.findById(trip.getVehicle().getId());
        trip.setDistance(calculateDistance(vehicle.getCompany().getOriginCity(),trip.getDesCity()));
        trip.setTripTime(calculateTripTime(trip.getDistance(),vehicle.getType().averageSpeed));
        trip.setArriveAt(calculateArriveTime(trip.getTripTime(), trip.getDepartAt()));
        trip.setPrice(calculatePrice(trip.getDistance(),vehicle.getType().priceRatio));
        try{
            repo.save(trip);
            logger.info("trip "+trip.toString()+" successfully saved.");
        }catch (DataAccessException ex){
            logger.error(ex.getMessage());
            ex.printStackTrace();
        }


    }

}
