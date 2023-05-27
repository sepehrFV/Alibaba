package com.alibaba.service;

import com.alibaba.model.Seat;
import com.alibaba.model.Ticket;
import com.alibaba.model.Trip;
import com.alibaba.repository.GenericRepo;
import com.alibaba.repository.SeatRepo;
import com.alibaba.repository.TicketRepo;
import com.alibaba.repository.TripRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class TicketServ extends GenericServiceImp<Ticket,Long> implements ITicketServ{

    private final TicketRepo repo;
    private final TripRepo tripRepo;
    private final SeatRepo seatRepo;

    @Autowired
    public TicketServ(TicketRepo repo, TripRepo tripRepo, SeatRepo seatRepo) {
        this.repo = repo;
        this.tripRepo = tripRepo;
        this.seatRepo = seatRepo;
    }









    @Override
    protected GenericRepo<Ticket, Long> getRepo() {
        return this.repo;
    }


    @Override
    public void checkValidation() {
        repo.findAll().forEach(t->{
            Date currentDate = new Date();
            if(currentDate.after(repo.findBusDepartAt(t.getTrip().getId()))){
                t.setExpired(true);
            }
        });
    }

    @Override
    public void save(Ticket ticket){

        int leftCapacity = repo.findLeftCapacity(ticket.getTrip().getId());
        List<Seat> filledSeats = repo.findFilledSeats(ticket.getTrip().getId());

        if(filledSeats.size()>=leftCapacity){
            System.out.println("bus capacity is already full");
        }else {
            List<Integer> filledSeatsNumbers = filledSeats.stream().map(Seat::getNumber).collect(Collectors.toList());
            List<Integer> allSeatsNumbers = IntStream.range(1,repo.findBusSeatNumber(ticket.getTrip().getId()))
                    .boxed().collect(Collectors.toList());//create a list with all seats number
            allSeatsNumbers.removeAll(filledSeatsNumbers);//then find which numbers of whole seats are still empty
            Random random = new Random();
            ticket.setSeatNumber(allSeatsNumbers.get(random.nextInt(allSeatsNumbers.size())));//set a new generated seat number for this ticket
        }
        Seat seat = new Seat(ticket.getSeatNumber(), repo.findUserGender(ticket.getUser().getId()));
        seatRepo.save(seat);
        if(tripRepo.findById(ticket.getTrip().getId()).isPresent()){
            Trip trip = tripRepo.findById(ticket.getTrip().getId()).get();
            filledSeats.add(seat);
            trip.setFilledSeats(filledSeats);
            tripRepo.save(trip);
            ticket.setTrip(trip);
            repo.save(ticket);
        }



    }

}
