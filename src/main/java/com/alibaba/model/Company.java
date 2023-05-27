package com.alibaba.model;


import com.alibaba.embeddable.LocationPoint;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Company extends BaseEntity {

    private String name;
    @Embedded
    private LocationPoint originCityLocation;
    private String originCityName;


}
