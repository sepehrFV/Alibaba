package com.alibaba.service;

import com.alibaba.model.User;

public interface IUserServ extends GenericService<User,Long>{

    Integer calculateAge(String dob);

}
