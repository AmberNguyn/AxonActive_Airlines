package com.example.demo.repository;

import com.example.demo.entity.Flight;
import com.example.demo.service.dto.FlightsAndTotalCostDto;
import com.example.demo.service.dto.NumberOfFlightsPerDepartureGateDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, String> {
    //1. Cho biết các chuyến bay đi Đà Lạt (DAD).
    List<Flight> findFlightByArrivalGateContaining(String arrivalGate);

    //4.	Cho biết các chuyến bay có độ dài đường bay nhỏ hơn 10.000km và lớn hơn 8.000km.
    List<Flight> findFlightByDistanceBetween(Integer distance1, Integer distance2);

    //5. Cho biết các chuyến bay xuất phát từ Sài Gòn (SGN) đi Ban Mê Thuộc (BMV).
    List<Flight> findFlightByDepartureGateAndArrivalGate(String departureGate, String arrivalGate);

    //6.	Có bao nhiêu chuyến bay xuất phát từ Sài Gòn (SGN).
    List<Flight> findFlightByDepartureGate(String departureGate);

    //14.	Cho biết các chuyến bay có thể ñược thực hiện bởi máy bay Airbus A320.

    @Query(value = "SELECT f.id FROM Flight f WHERE f.distance < (SELECT a.range from Airplane a WHERE a.type LIKE :type)", nativeQuery = true)
    List<String> findAllTheFlightsThatCanBeDoneByACertainTypeOfAirplane(@Param("type") String airplaneType);

    //-- 17.	Giả sử một hành khách muốn đi thẳng từ ga A đến ga B rồi quay trở về ga A.
    //-- Cho biết các đường bay nào có thể đáp ứng yêu cầu này.
//    List<Flight> findFlightByDepartureGateContainingAndArrivalGateContaining(String departureGate, String arrivalGate);

    @Query(value = "SELECT f1.id FROM flight f1, flight f2 WHERE f1.departure_gate = f2.arrival_gate " +
            "AND f2.departure_gate = f1.arrival_gate", nativeQuery = true)
   List<String> findFlightThatProvidesTwoWaysTickets(String departureGate, String arrivalGate);

    //-- 18. Với mỗi ga có chuyến bay xuất phát từ đó
    //-- cho biết có bao nhiêu chuyến bay khởi hành từ ga đó.

    @Query(value = "SELECT new com.example.demo.service.dto.NumberOfFlightsPerDepartureGateDto(departureGate, COUNT(departureGate)) " +
            "FROM Flight GROUP BY departureGate" )
    List<NumberOfFlightsPerDepartureGateDto> findNumberOfFlightsPerDepartureGate();

    //-- 19. Với mỗi ga có chuyến  bay xuất phát từ đó cho biết tổng chi phí
    //-- phải trả cho phi công lái các chuyến bay khởi hành từ ga đó.

//    @Query(value = "SELECT new com.example.demo.service.dto.FlightsAndTotalCostDto(departureGate, SUM(cost)) " +
//            "FROM Flight GROUP BY departureGate")
//    List<FlightsAndTotalCostDto> calculateTotalCostForEachFlight();

}
