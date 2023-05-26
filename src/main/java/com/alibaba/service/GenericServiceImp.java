package com.alibaba.service;

import com.alibaba.repository.GenericRepo;
import javassist.NotFoundException;
import java.util.List;
import java.util.Optional;

public abstract class GenericServiceImp<E,ID> implements GenericService<E,ID>{

    protected abstract GenericRepo<E,ID> getRepo();

    @Override
    public void save(E entity) {
        getRepo().save(entity);
    }

    @Override
    public Optional<E> findById(ID id) {
        if(existById(id)){
            return getRepo().findById(id);
        }else throw new RuntimeException("operation canceled because id does not exist"+"id:"+id);

    }

    @Override
    public List<E> findAll() {
        return getRepo().findAll();
    }

    @Override
    public void deleteById(ID id) {
        if (existById(id)){
            getRepo().deleteById(id);
        }else throw new RuntimeException("operation canceled because id does not exist"+"id:"+id);


    }

    @Override
    public boolean existById(ID id) {
        return getRepo().findById(id).isPresent();

    }


}
