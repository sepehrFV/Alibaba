package com.alibaba.service;

import com.alibaba.model.Sit;
import com.alibaba.model.Ticket;
import com.alibaba.repository.GenericRepo;
import com.alibaba.repository.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class TicketServ extends GenericServiceImp<Ticket,Long> implements ITicketServ{

    private final TicketRepo repo;

    @Autowired
    public TicketServ(TicketRepo repo) {
        this.repo = repo;
    }


    @Override
    protected GenericRepo<Ticket, Long> getRepo() {
        return this.repo;
    }


    @Override
    public void checkValidation() {
        repo.findAll().stream().forEach(t->{
            Date currentDate = new Date();
            if(currentDate.after(repo.findBusDepartAt(t.getTrip().getId()))){
                t.setExpired(true);
            }
        });
    }

    @Override
    public void save(Ticket ticket){

        Random random = new Random();
        int leftCapacity = repo.findLeftCapacity(ticket.getTrip().getId());
        List<Sit> filledSits = repo.findFilledSits(ticket.getTrip().getId());

        if(filledSits.size()>=leftCapacity){
            System.out.println("bus capacity is already full");
        }else {
            int sitNumber = random.nextInt(leftCapacity);
            filledSits.stream().forEach(s->{
                if(s.getNumber()==sitNumber){

                }
            });
        }
    }

}
