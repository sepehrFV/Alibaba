package com.alibaba.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Ticket extends BaseEntity {

    @OneToOne
    private User user;
    private Double distance;
    private Integer tripTime;
    @ManyToOne
    private Bus bus;
    private Date departAt;
    private Date arriveAt;
    private Integer price;


}
