package com.alibaba.service;

import com.alibaba.model.User;
import com.alibaba.repository.GenericRepo;
import com.alibaba.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServ extends GenericServiceImp<User,Long> implements IUserServ{

    private final UserRepo repo;

    @Autowired
    public UserServ(UserRepo repo) {
        this.repo = repo;
    }

    @Override
    protected GenericRepo<User, Long> getRepo() {
        return this.repo;
    }


}
