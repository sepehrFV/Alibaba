package com.alibaba.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Trip extends BaseEntity {

    @OneToOne
    private Bus bus;
    @ManyToOne
    @JoinColumn(name = "descity_Id")
    private DesCity desCity;
    @OneToMany
    @JsonIgnore
    private List<Seat> filledSeats;
    @JsonIgnore
    private Integer leftCapacity;
    @NotNull
    private Date departAt;
    @JsonIgnore
    private Date arriveAt;
    @JsonIgnore
    private Double distance;
    @JsonIgnore
    private Integer tripTime;
    @JsonIgnore
    private Double price;
    @JsonIgnore
    //@Value("false")
    private boolean isExpired;


}
