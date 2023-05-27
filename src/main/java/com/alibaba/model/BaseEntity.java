package com.alibaba.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@EntityListeners(AuditingEntityListener.class)
@Audited
@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public abstract class BaseEntity {

    @LastModifiedDate
    private Date lastModifiedDate;
    @LastModifiedBy
    private String modifiedBy;
    @CreatedBy
    @JsonIgnore
    private String createdBy;
    @CreatedDate
    private Date createdDate;
    @Version
    private Integer version;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


}
