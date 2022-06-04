package com.example.demo.repository;

import com.example.demo.entity.Certificate;
import com.example.demo.service.dto.PilotsAndNumberOfAirplanesTheyCanFlyDto;
import com.example.demo.service.dto.PilotsWhoCanFlyMoreThan3TypesOfPlanesAndItsMaxRangeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate, Integer> {

    //9.	Cho biết mã số của các phi công lái máy báy Boeing.
    @Query(value = "SELECT c.* FROM Certificate c " +
                    "WHERE c.airplane_id IN (SELECT id FROM Airplane WHERE type = :airplaneType)", nativeQuery = true)
    List<Certificate> findAllThePilotsWhoCanFlyATypeOfAirplane(@Param("airplaneType") String airplaneType);

    // 10.	Cho biết các nhân viên có thể lái máy bay có mã số 747.
    List<Certificate> findEmployeeByAirplaneId(Integer airplaneId);

    //11.	Cho biết mã số của các loại máy bay mà nhân viên có họ Nguyễn có thể lái.
    List<Certificate> findAirplaneByEmployeeNameContaining(String name);

    //12.	Cho biết mã số của các phi công vừa lái được Boeing vừa lái được Airbus.

    @Query(value = "SELECT c.employee_id FROM Certificate c WHERE airplane_id IN (SELECT id FROM Airplane WHERE type = :airplaneType1) " +
            "INTERSECT SELECT c.employee_id FROM Certificate c WHERE airplane_id IN (SELECT id FROM Airplane WHERE type = :airplaneType2) ", nativeQuery = true)
    List<Integer> findAllThePilotsWhoCanFlyTwoTypesOfAirplanes(@Param("airplaneType1") String airplaneType1,
                                                                   @Param("airplaneType2") String airplaneType2);


    //15. Cho biết tên của các phi công lái máy bay Boeing.
    List<Certificate> findPilotsByAirplaneTypeContaining(String airplaneType);


    // -- 22. Cho biết mã số của các phi công chỉ lái được 3 loại máy bay
    @Query(value = "SELECT employee.employeeId " +
            "FROM Certificate " +
            "GROUP BY employee.employeeId " +
            "HAVING COUNT (airplane.id) = 3")
    List<String> findListOfPilotsWhoCanOnlyFly3TypesOfPlanes();

    // 23.
    // -- 23. Với mỗi phi công có thể lái nhiều hơn 3 loại máy bay,
    //-- cho biết mã số phi công và tầm bay lớn nhất của các loại máy bay
    //-- mà phi công đó có thể lái.

//    @Query (value = "SELECT new com.example.demo.service.dto.PilotsWhoCanFlyMoreThan3TypesOfPlanesAndItsMaxRangeDto(" +
//            "c.employee.employeeId, MAX(c.airplane.range)) " +
//            "FROM Certificate c " +
//            "JOIN Airplane a " +
//            "ON c.airplane.id = a.id " +
//            "WHERE c.employee.employeeId IN  " +
//            "(SELECT employee.employeeId " +
//            "FROM Certificate " +
//            " GROUP BY employee.employeeId " +
//            " HAVING COUNT(airplane.id) > 3) " +
//            "GROUP BY employee.employeeId")
//    List<PilotsWhoCanFlyMoreThan3TypesOfPlanesAndItsMaxRangeDto> findListOfPilotsWhoCanFlyMoreThan3TypesOfPlanesAndTheirMaximumRange();

    @Query(nativeQuery=true)
    List<PilotsWhoCanFlyMoreThan3TypesOfPlanesAndItsMaxRangeDto> findPilotsCanFly3TypesOfPlanesAndItsMaxRange();


    //-- 24. Với mỗi phi công cho biết mã số phi công
    //-- và tổng số loại máy bay mà phi công đó có thể lái.

    @Query(value = "SELECT new com.example.demo.service.dto.PilotsAndNumberOfAirplanesTheyCanFlyDto(c.employee.employeeId, COUNT(c.airplane.id)) " +
            "FROM Certificate c " +
            "GROUP BY c.employee.employeeId")
    List<PilotsAndNumberOfAirplanesTheyCanFlyDto> findPilotsAndNumberOfAirplanesTheyCanFly();
}
