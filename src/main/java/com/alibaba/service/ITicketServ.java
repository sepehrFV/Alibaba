package com.alibaba.service;

import com.alibaba.model.Ticket;

import java.util.Date;

public interface ITicketServ extends GenericService<Ticket,Long>{

    void checkValidation();

}
