package com.alibaba.model;


import com.alibaba.enums.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.Period;


@Entity
@Data
@NoArgsConstructor
@Table(name = "real_user")
public class User extends BaseEntity {

    @NotNull
    private String username;
    @NotNull
    private String password;
    private String name;
    @NotNull
    private Gender gender;
    @NotNull
    @Transient
    private String dob;
    private Integer age;
    private String nationalCode;

    public Integer calculateAge(String dob){
        String[] date = new String[2];
        date = dob.split("/");
        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[2]);
        LocalDate dateOfBirth = LocalDate.of(year,month,day);
        int age = Period.between(dateOfBirth,LocalDate.now()).getYears();
        return age;

    }


}
