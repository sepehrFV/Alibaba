package com.alibaba.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
@NoArgsConstructor
public class Bus extends BaseEntity {

    private Integer seats;
    @ManyToOne
    @JoinColumn(name ="company_Id")
    private Company company;



}
