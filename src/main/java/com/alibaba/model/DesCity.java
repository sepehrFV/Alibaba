package com.alibaba.model;


import com.alibaba.embeddable.LocationPoint;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
public class DesCity extends BaseEntity {

    @NotNull
    private String name;
    @Embedded
    private LocationPoint location;

}
