package com.example.demo.service;


import com.example.demo.entity.Flight;
import com.example.demo.repository.FlightRepository;
import com.example.demo.service.dto.FlightsAndTotalCostDto;
import com.example.demo.service.dto.NumberOfFlightsPerDepartureGateDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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


    //14.	Cho biết các chuyến bay có thể ñược thực hiện bởi máy bay Airbus A320.
    public List<String> findAllTheFlightsThatCanBeDoneByACertainTypeOfAirplane(String airplaneType);


    //-- 17.	Giả sử một hành khách muốn đi thẳng từ ga A đến ga B rồi quay trở về ga A.
    //-- Cho biết các đường bay nào có thể đáp ứng yêu cầu này.
//    public List<String> listOfAllTheFlightFromAtoB(String departureGate, String arrivalGate);

    public List<String> findFlightThatProvidesTwoWaysTickets(String departureGate, String arrivalGate);

    //-- 18. Với mỗi ga có chuyến bay xuất phát từ đó
    //-- cho biết có bao nhiêu chuyến bay khởi hành từ ga đó.
    public List<NumberOfFlightsPerDepartureGateDto> findNumberOfFlightsPerDepartureGate();

    //-- 19. Với mỗi ga có chuyến  bay xuất phát từ đó cho biết tổng chi phí
    //-- phải trả cho phi công lái các chuyến bay khởi hành từ ga đó.
//    List<FlightsAndTotalCostDto> calculateTotalCostForEachFlight();
}
