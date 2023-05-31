package com.alibaba.service;

import com.alibaba.enums.VehicleType;
import com.alibaba.model.Vehicle;
import com.alibaba.repository.GenericRepo;
import com.alibaba.repository.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class VehicleServ extends GenericServiceImp<Vehicle,Long> implements IVehicleServ{

    private final VehicleRepo repo;

    @Autowired
    public VehicleServ(VehicleRepo repo) {
        this.repo = repo;
    }

    @Override
    protected GenericRepo<Vehicle, Long> getRepo() {
        return this.repo;
    }

    @Override
    protected Class<?> getExtendedClass() {
        return this.getClass();
    }

    @Override
    public void save(Vehicle vehicle){

        logger.debug("enter "+getExtendedClass().getName()+"'s save()...");
        try{
            if(vehicle.getCapacity()==null){
                vehicle.setCapacity(vehicle.getType().defaultCapacity);
                logger.debug("vehicle default capacity set...");
            }
            repo.save(vehicle);
            logger.info("A new "+getExtendedClass().getName()+"'s object has made successful");
        }catch (DataAccessException ex){
            logger.error(ex.getMessage());
            ex.printStackTrace();
        }

    }

}
