package com.alibaba.model;

import com.alibaba.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@Data
@NoArgsConstructor
public class Sit extends BaseEntity{

    private Integer number;
    private boolean isEmpty;
    private Gender reservedPersonGender;

}
