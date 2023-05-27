package com.alibaba.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Ticket extends BaseEntity {

    @OneToOne
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trip_Id")
    private Trip trip;
    @JsonIgnore
    private Integer seatNumber;
    @JsonIgnore
    private boolean expired;

}
