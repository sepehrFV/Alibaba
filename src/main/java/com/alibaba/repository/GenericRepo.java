package com.alibaba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface GenericRepo<E,ID> extends JpaRepository<E,ID>,PagingAndSortingRepository<E,ID> {

    List<E> findAll();
    Optional<E> findById(ID id);

}
