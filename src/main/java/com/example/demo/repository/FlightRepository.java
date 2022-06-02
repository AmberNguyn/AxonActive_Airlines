package com.example.demo.repository;

import com.example.demo.entity.Airplane;
import com.example.demo.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
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

    //13.	Cho biết các loại máy bay có thể thực hiện chuyến bay VN280.

}
