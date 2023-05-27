package com.alibaba.model;

import com.alibaba.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seat extends BaseEntity{

    private Integer number;
    private Gender reservedPersonGender;

}
