package com.alibaba.service;

import javassist.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface GenericService<E,ID> {

    void save(E entity);
    Optional<E> findById(ID id);
    List<E> findAll();
    void deleteById(ID id);
    boolean existById(ID id);

}
