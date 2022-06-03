package com.example.demo.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Airplane {
    @Id
    private Integer id;

    @Column
    private String type;

    @Column
    private Integer range;
}
