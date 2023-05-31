package com.alibaba.service;

import com.alibaba.embeddable.Seat;
import com.alibaba.model.*;
import com.alibaba.repository.GenericRepo;
import com.alibaba.repository.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class TicketServ extends GenericServiceImp<Ticket, Long> implements ITicketServ {

    private final TicketRepo repo;
    private final ITripServ tripServ;
    private final IUserServ userServ;

    @Autowired
    public TicketServ(TicketRepo repo, ITripServ tripServ, IUserServ userServ) {
        this.repo = repo;
        this.tripServ = tripServ;
        this.userServ = userServ;
    }


    @Override
    protected GenericRepo<Ticket, Long> getRepo() {
        return this.repo;
    }

    @Override
    protected Class<?> getExtendedClass() {
        return this.getClass();
    }


    @Override
    public void checkValidation() {
        repo.findAll().forEach(t -> {
            Date currentDate = new Date();
            if (currentDate.after(repo.findVehicleDepartAt(t.getTrip().getId()))) {
                t.setExpired(true);
            }
        });
    }

    @Override
    public void save(Ticket ticket) {

        logger.debug("enter ticket's save()...");
        Trip trip = tripServ.findById(ticket.getTrip().getId());
        Vehicle vehicle = trip.getVehicle();
        User user = userServ.findById(ticket.getUser().getId());

        //generate a new seat number
        List<Seat> reservedSeats = trip.getSeatList();
        List<Integer> reservedSeatsNumber = reservedSeats.stream().map(Seat::getNumber).collect(Collectors.toList());
        List<Integer> wholeCapacityNumber = IntStream.range(1, vehicle.getCapacity()).boxed().collect(Collectors.toList());
        wholeCapacityNumber.removeAll(reservedSeatsNumber);
        if(wholeCapacityNumber.isEmpty()){
            logger.error("trip capacity is full...");
        }if(trip.getDepartAt().before(new Date())){//check validation
            logger.error("vehicle is already depart...");
        } else {
            Random random = new Random();
            Integer generatedSeatNumber = wholeCapacityNumber.get(random.nextInt(wholeCapacityNumber.size()));
            ticket.setSeatNumber(generatedSeatNumber);
            ticket.setExpired(false);
            Seat seat = new Seat(generatedSeatNumber,user.getGender());
            reservedSeats.add(seat);
            trip.setSeatList(reservedSeats);
            try{
                tripServ.save(trip);
                repo.save(ticket);
                logger.info("new ticket "+ticket.toString()+" successfully saved.");
            }catch (DataAccessException ex){
                logger.error(ex.getMessage());
                ex.printStackTrace();
            }
        }


    }

}
