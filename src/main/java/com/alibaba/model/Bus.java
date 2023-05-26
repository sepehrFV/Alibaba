package com.alibaba.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
@NoArgsConstructor
public class Bus extends BaseEntity {

    private Integer sits;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="company_Id")
    private Company company;



}
