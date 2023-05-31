package com.alibaba.embeddable;

import com.alibaba.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seat {


    private Integer number;
    private Gender reservedPersonGender;


}
