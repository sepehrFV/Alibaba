package com.alibaba.model;


import com.alibaba.embeddable.LocationPoint;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Company extends BaseEntity {

    private String name;
    @JsonIgnoreProperties
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "company")
    private List<Bus> buses;
    private String originCityName;
    @Embedded
    private LocationPoint originCityLocation;


}
