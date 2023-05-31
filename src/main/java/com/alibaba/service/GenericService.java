package com.alibaba.service;

import java.util.List;

public interface GenericService<E,ID> {

    void save(E entity);
    E findById(ID id);
    List<E> findAll();
    void deleteById(ID id);
    boolean existById(ID id);

}
