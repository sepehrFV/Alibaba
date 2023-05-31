package com.alibaba.model;

import com.alibaba.embeddable.Seat;
import com.alibaba.enums.DesCity;
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

    @OneToOne(fetch = FetchType.LAZY)
    private Vehicle vehicle;
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "seat",joinColumns = @JoinColumn(name = "trip_id"))
    @JsonIgnore
    private List<Seat> seatList;
    @Enumerated
    private DesCity desCity;
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
