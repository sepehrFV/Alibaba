package com.alibaba.repository;


import com.alibaba.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends GenericRepo<User,Long>{
}
