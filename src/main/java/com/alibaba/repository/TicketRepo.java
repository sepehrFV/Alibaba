package com.alibaba.repository;

import com.alibaba.model.Ticket;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface TicketRepo extends GenericRepo<Ticket,Long>{

    @Query(value = "SELECT t.departAt FROM Trip t WHERE t.id =:id")
    Date findVehicleDepartAt(@Param("id") Long tripId);

    /*@Query(value = "SELECT t.filledSeats FROM Trip t WHERE t.id =:id")
    List<Seat> findFilledSeats(@Param("id") Long tripId);

    @Query(value = "SELECT t.leftCapacity FROM Trip t WHERE t.id =:id")
    Integer findLeftCapacity(@Param("id") Long tripId);

    @Query(value = "SELECT t.bus.seats FROM Trip t WHERE t.id =:id")
    Integer findBusSeatNumber(@Param("id") Long id);

    @Query(value = "SELECT u.gender FROM User u WHERE u.id =:id")
    Gender findUserGender(@Param("id") Long id);*/



}
