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

@SqlResultSetMapping(
        name = "PilotsCanFly3TypesOfAirplanesAndItsMaxRange",
        classes = {
                @ConstructorResult(
                        targetClass = com.example.demo.service.dto.PilotsWhoCanFlyMoreThan3TypesOfPlanesAndItsMaxRangeDto.class,
                        columns = {
                                @ColumnResult(name = "employeeId", type = Integer.class),
                                @ColumnResult(name = "airplaneMaxRange", type = Integer.class)
                        }

                )
        }
)
@NamedNativeQuery(
        name = Certificate.FIND_PILOTS_CAN_FLY_3_TYPES_OF_AIRPLANES_AND_ITS_MAX_RANGE,
        query = "SELECT c.employee_id as employeeId, MAX(a.range) as airplaneMaxRange " +
                "FROM certificate c JOIN airplane a ON c.airplane_id = a.id " +
                "WHERE c.employee_id IN (SELECT employee_id " +
                "FROM certificate GROUP BY employee_id HAVING COUNT(airplane_id) > 3) " +
                "GROUP BY employee_id",
        resultSetMapping = "PilotsCanFly3TypesOfAirplanesAndItsMaxRange")
public class Certificate {

    public static final String FIND_PILOTS_CAN_FLY_3_TYPES_OF_AIRPLANES_AND_ITS_MAX_RANGE = "Certificate.findPilotsCanFly3TypesOfPlanesAndItsMaxRange";


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "certificate_id")
    private Integer certificateId;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "airplane_id")
    private Airplane airplane;
}
