package com.alibaba.service;

import com.alibaba.model.Sit;
import com.alibaba.repository.GenericRepo;
import org.springframework.stereotype.Service;

@Service
public class SitServ extends GenericServiceImp<Sit,Long> implements ISitServ{
    @Override
    protected GenericRepo<Sit, Long> getRepo() {
        return null;
    }
}
