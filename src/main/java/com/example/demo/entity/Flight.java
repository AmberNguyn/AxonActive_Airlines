package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Flight {
    @Id
    private String flightID;

    @Size(max = 3)
    private String departureGate;

    @Size(max = 3)
    private String arrivalGate;

    @Column
    private Integer distance;

    @Column
    private LocalDate departureTime;

    @Column
    private LocalDate arrivalTime;

    @Column
    private Integer cost;
}
