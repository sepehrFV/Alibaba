package com.alibaba.repository;

import com.alibaba.model.Company;
import com.alibaba.model.Vehicle;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepo extends GenericRepo<Company,Long>{


    Company findCompanyByName(String name);

    @Query(value = "SELECT v FROM vehicle v INNER JOIN company c ON c.id=v.company_Id WHERE c.id =:id",nativeQuery = true)
    List<Vehicle> findVehiclesByCompanyId(@Param("id") Long id);

    @Query(value = "SELECT v FROM Vehicle v where v.company.name=:name")
    List<Vehicle> findVehiclesByCompanyName(@Param("name") String name);


}
