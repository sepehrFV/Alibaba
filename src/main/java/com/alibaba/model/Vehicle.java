package com.alibaba.model;

import com.alibaba.enums.VehicleType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Vehicle extends BaseEntity {

    private Integer capacity;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
    private VehicleType type;


}
