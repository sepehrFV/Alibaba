package com.alibaba.repository;

import com.alibaba.model.Sit;
import com.alibaba.model.Ticket;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TicketRepo extends GenericRepo<Ticket,Long>{

    @Query(value = "SELECT Trip.departAt FROM Trip t WHERE t.id =:id")
    Date findBusDepartAt(@Param("id") Long tripId);

    @Query(value = "SELECT Trip.filledSits FROM Trip t WHERE t.id =: id")
    List<Sit> findFilledSits(@Param("id") Long tripId);

    @Query(value = "SELECT Trip.leftCapacity FROM Trip t WHERE t.id =: id")
    Integer findLeftCapacity(@Param("id") Long tripId);



}
