package com.alibaba.model;


import com.alibaba.embeddable.LocationPoint;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class DesCity extends BaseEntity {

    private String name;
    @Embedded
    private LocationPoint location;

}
