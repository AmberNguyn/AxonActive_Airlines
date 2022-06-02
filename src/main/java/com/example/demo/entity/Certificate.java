package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Certificate {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "certificate_id")
    private Integer certificateId;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "airplane_id")
    private Airplane airplane;
}
