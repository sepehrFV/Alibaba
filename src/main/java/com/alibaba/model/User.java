package com.alibaba.model;


import com.alibaba.enums.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private String dob;
    @JsonIgnore
    private Integer age;
    private String nationalCode;


}
