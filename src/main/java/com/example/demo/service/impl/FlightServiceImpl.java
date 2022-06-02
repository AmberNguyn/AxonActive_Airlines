package com.example.demo.service.impl;

import com.example.demo.entity.Flight;
import com.example.demo.repository.FlightRepository;
import com.example.demo.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService {
    @Autowired
    FlightRepository flightRepository;

    @Override
    public List<Flight> getAll() {
        return flightRepository.findAll();
    }

    @Override
    public Optional<Flight> findFlightById(String flightId) {
        return flightRepository.findById(flightId);
    }

    @Override
    public Flight saveFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public void deleteFlight(String name) {
        flightRepository.deleteById(name);
    }

    //Cho biết các chuyến bay đi Đà Lạt (DAD).
    @Override
    public List<Flight> findFlightByArrivalGateContaining(String arrivalGate) {
        return flightRepository.findFlightByArrivalGateContaining(arrivalGate);
    }

    @Override
    //4.	Cho biết các chuyến bay có độ dài đường bay nhỏ hơn 10.000km và lớn hơn 8.000km.
    public List<Flight> findFlightByDistanceBetween(Integer distance1, Integer distance2) {
        return flightRepository.findFlightByDistanceBetween(distance1, distance2);
    }

    @Override
    //5. Cho biết các chuyến bay xuất phát từ Sài Gòn (SGN) đi Ban Mê Thuộc (BMV).
    public List<Flight> findFlightByDepartureGateAndArrivalGate(String departureGate, String arrivalGate) {
        return flightRepository.findFlightByDepartureGateAndArrivalGate(departureGate, arrivalGate);
    }

    @Override
    //6.	Có bao nhiêu chuyến bay xuất phát từ Sài Gòn (SGN).
    public int findTheNumberOfFlightByDepartureGate(String departureGate) {
        return flightRepository.findFlightByDepartureGate(departureGate).size();
    }

}
