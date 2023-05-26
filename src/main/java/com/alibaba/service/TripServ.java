package com.alibaba.service;


import com.alibaba.embeddable.LocationPoint;
import com.alibaba.model.Bus;
import com.alibaba.model.Trip;
import com.alibaba.repository.BusRepo;
import com.alibaba.repository.GenericRepo;
import com.alibaba.repository.TripRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@Service
public class TripServ extends GenericServiceImp<Trip, Long> implements ITripServ {

    private final TripRepo repo;
    private final BusRepo busRepo;

    @Autowired
    public TripServ(TripRepo repo, BusRepo busRepo) {
        this.repo = repo;
        this.busRepo = busRepo;
    }


    @Override
    protected GenericRepo<Trip, Long> getRepo() {
        return repo;
    }

    @Override
    public Double calculateDistance(LocationPoint originTown, LocationPoint destinationTown) {
        final int r = 6371;//radius of earth
        double latDistance = Math.toRadians(originTown.getLatitude() - destinationTown.getLatitude());
        double lonDistance = Math.toRadians(originTown.getLongitude() - destinationTown.getLongitude());
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(destinationTown.getLatitude())) * Math.cos(originTown.getLatitude())
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return r * c;//km

    }


    @Override
    public Integer calculateTripTime(Double distance) {
        final Integer averageSpeed = 70;
        return (Integer) (int) (distance / 70);
    }

    @Override
    public Date calculateArriveTime(Integer tripTime, Date departAt) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(departAt);
        calendar.add(Calendar.HOUR_OF_DAY, tripTime);
        return calendar.getTime();
    }

    @Override
    public Double calculatePrice(Double distance) {
        Double pricePerEachKm = 0.3;
        return (distance * pricePerEachKm);
    }

    @Override
    public void expiredCheck(Date departTime) {
        repo.findAll().stream().forEach(t -> {
            Date currentDate = new Date();
            if (currentDate.after(t.getDepartAt())) t.setExpired(true);
        });
    }


    @Override
    public void save(Trip trip) {
        Optional<Bus> bus = busRepo.findById(trip.getBus().getId());
        if (bus.isPresent()) {
            trip.setDistance(calculateDistance(bus.get().getCompany().getOriginCityLocation(), trip.getDesCity().getLocation()));
            trip.setTripTime(calculateTripTime(trip.getDistance()));
            trip.setArriveAt(calculateArriveTime(trip.getTripTime(), trip.getDepartAt()));
            trip.setPrice(calculatePrice(trip.getDistance()));
            trip.setLeftCapacity(bus.get().getSits());
        }
        repo.save(trip);

    }

}
