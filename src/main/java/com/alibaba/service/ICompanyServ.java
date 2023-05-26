package com.alibaba.service;

import com.alibaba.model.Bus;
import com.alibaba.model.Company;

import java.util.List;

public interface ICompanyServ extends GenericService<Company,Long>{
    Company findByName(String name);
    List<Bus> findBusesByCompanyId(Long id);
    List<Bus> findBusesByCompanyName(String name);

}
