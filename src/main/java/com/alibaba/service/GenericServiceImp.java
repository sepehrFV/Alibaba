package com.alibaba.service;

import com.alibaba.repository.GenericRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;

import java.util.List;

public abstract class GenericServiceImp<E,ID> implements GenericService<E,ID>{

    public static final Logger logger = LoggerFactory.getLogger(GenericServiceImp.class);

    protected abstract GenericRepo<E,ID> getRepo();
    protected abstract Class<?> getExtendedClass();

    @Override
    public void save(E entity) {
        logger.debug("Enter "+getExtendedClass().getName()+"'s save()");
        try{
            getRepo().save(entity);
            logger.info("A new "+getExtendedClass().getName()+"'s object has made successful");
        }catch (DataAccessException ex){
            logger.error(ex.getMessage());
            ex.printStackTrace();

        }
    }

    @Override
    public E findById(ID id) {
        logger.debug("Enter "+getExtendedClass().getName()+"'s findById()");
        if (getRepo().findById(id).isPresent()){
            return getRepo().findById(id).get();
        }else throw new NullPointerException();
    }

    @Override
    public List<E> findAll() {
        logger.debug("Enter "+getClass().getName()+"'s findAll()...");
        List<E> eList = null;
        try{
            eList =  getRepo().findAll();
            logger.debug("method return is: "+eList.toString());
        }catch (NullPointerException ex){
            logger.error(ex.getMessage());
            ex.printStackTrace();
        }
        return eList;
    }

    @Override
    public void deleteById(ID id) {
        logger.debug("Enter "+getExtendedClass().getName()+"'s delete()");
        if (existById(id))
            getRepo().deleteById(id);
        else{
            logger.error("operation canceled because id: " + id + " does not exist");
            throw new RuntimeException("operation canceled because id: " + id + " does not exist");
        }


    }

    @Override
    public boolean existById(ID id) {
        return getRepo().existsById(id);

    }


}
