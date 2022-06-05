package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder

@SqlResultSetMapping(
        name = "flightsCanBeDoneByATypeOfAirplane",
        classes = {
                @ConstructorResult(
                        targetClass = com.example.demo.service.dto.FlightsCanBeDoneByATypeOfAirplaneDto.class,
                        columns = {
                                @ColumnResult(name = "flightId", type = String.class),
                                @ColumnResult(name = "distance", type = Integer.class)
                        }
                )
        }

)


@NamedNativeQuery(
        name = Flight.FLIGHTS_CAN_BE_DONE_BY_A_TYPE_OF_AIRPLANE,
        query = "SELECT f.id as flightId, f.distance as distance FROM flight f " +
                "WHERE f.distance < ( SELECT MIN(a.range) " +
                "FROM airplane a " +
                "WHERE a.type LIKE '%Boeing%')",
        resultSetMapping = "flightsCanBeDoneByATypeOfAirplane"

)


public class Flight {
    public static final String FLIGHTS_CAN_BE_DONE_BY_A_TYPE_OF_AIRPLANE = "Flight.findFlightsThatCanBeDoneByATypeOfAirplane";


    @Id
    private String id;

    @Size(max = 3)
    private String departureGate;

    @Size(max = 3)
    private String arrivalGate;

    @Column
    private Integer distance;

    @Column
    private LocalTime departureTime;

    @Column
    private LocalTime arrivalTime;

    @Column
    private Integer cost;
}
