package com.alibaba.repository;

import com.alibaba.model.Ticket;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepo extends GenericRepo<Ticket,Long>{
}
