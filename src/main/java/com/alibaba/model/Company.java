package com.alibaba.model;


import com.alibaba.enums.DesCity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Company extends BaseEntity {

    private String name;
    private Date foundation;
    @Enumerated
    private DesCity originCity;

}
