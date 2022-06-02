package com.example.demo.service;


import com.example.demo.entity.Flight;
import com.example.demo.repository.FlightRepository;

import java.util.List;
import java.util.Optional;

public interface FlightService {
    List<Flight> getAll();

    Optional<Flight> findFlightById(String flightId);

    Flight saveFlight(Flight flight);

    void deleteFlight(String flightId);

    //1. Cho biết các chuyến bay đi Đà Lạt (DAD).
    public List<Flight> findFlightByArrivalGateContaining(String arrivalGate);

    //4.	Cho biết các chuyến bay có độ dài đường bay nhỏ hơn 10.000km và lớn hơn 8.000km.
    public List<Flight> findFlightByDistanceBetween(Integer distance1, Integer distance2);

    //5. Cho biết các chuyến bay xuất phát từ Sài Gòn (SGN) đi Ban Mê Thuộc (BMV).
    public List<Flight> findFlightByDepartureGateAndArrivalGate(String departureGate, String arrivalGate);

    //6.	Có bao nhiêu chuyến bay xuất phát từ Sài Gòn (SGN).
    public int findTheNumberOfFlightByDepartureGate(String departureGate);
}
