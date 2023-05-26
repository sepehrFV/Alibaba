package com.alibaba.repository;

import com.alibaba.model.Bus;
import com.alibaba.model.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepo extends GenericRepo<Company,Long>{

    Company findCompanyByName(String name);
    @Query(value = "SELECT b FROM Bus b WHERE b.company.id =:id")
    List<Bus> findBusesByCompanyId(@Param("id") Long id);

    @Query(value = "SELECT b FROM Bus b INNER JOIN Company c WHERE c.name =:name")
    List<Bus> findBusesByCompanyName(@Param("name") String name);


}
