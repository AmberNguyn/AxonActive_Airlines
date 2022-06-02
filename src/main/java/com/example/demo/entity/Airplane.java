package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Airplane {
    @Id
    private Integer airplaneId;

    @Column
    private String airplaneType;

    @Column
    private Integer flyingDistance;
}
