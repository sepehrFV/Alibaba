package com.alibaba.service;

import com.alibaba.model.User;
import com.alibaba.repository.GenericRepo;
import com.alibaba.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

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

    @Override
    public Integer calculateAge(String dob){
        String[] date = new String[2];
        date = dob.split("/");
        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[2]);
        LocalDate dateOfBirth = LocalDate.of(year,month,day);
        int age = Period.between(dateOfBirth,LocalDate.now()).getYears();
        return age;

    }

    @Override
    public void save(User user){
        user.setAge(calculateAge(user.getDob()));
        repo.save(user);
    }
}
