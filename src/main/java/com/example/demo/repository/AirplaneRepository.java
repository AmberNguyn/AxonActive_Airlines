package com.example.demo.repository;

import com.example.demo.entity.Airplane;
import com.example.demo.service.dto.AirplaneDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirplaneRepository extends JpaRepository<Airplane, Integer> {
    //Cho biết các loại máy bay có tầm bay lớn hơn 10,000km.
    List<Airplane> findAirplaneByRangeGreaterThan(Integer flyingDistance);

    //7.	Có bao nhiêu loại máy báy Boeing.
    List<Airplane> findAirplaneByTypeContaining(String typeOfAirplane);

    //13.	Cho biết các loại máy bay có thể thực hiện chuyến bay VN280.
    @Query(value = "SELECT a.type FROM airplane a WHERE a.range > (SELECT f.distance FROM flight f where f.id = :flight_id)", nativeQuery = true)
    List<String> findAirplaneThatCanSatisfyACertainFlight(@Param("flight_id") String flightId);

    //-- 16. Với mỗi loại máy bay có phi công lái cho biết mã số,
    //-- loại máy báy và tổng số phi công có thể lái loại máy bay đó.

    @Query (value = "SELECT new com.example.demo.service.dto.AirplaneDto(a.type, a.id, COUNT(c.employee)) " +
            "FROM Airplane a LEFT JOIN Certificate c " +
            "ON a.id = c.airplane.id " +
            "GROUP BY a.id ")
    List<AirplaneDto> listOfAirplaneIdAndAirplaneTypeAndNumberOfPilotsWhoCanFlyThem();

}
