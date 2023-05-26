package com.alibaba.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bus extends BaseEntity {

    private Integer sits;
    private Integer availableSitCount;
    @ManyToOne
    @JoinColumn(name ="company_Id")
    private Company company;
    @ManyToOne
    private DesCity desCity;


}
