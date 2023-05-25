package com.alibaba.repository;

import com.alibaba.model.Company;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepo extends GenericRepo<Company,Long>{
}
