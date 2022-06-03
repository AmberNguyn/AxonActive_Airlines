package com.example.demo.service.impl;

import com.example.demo.entity.Flight;
import com.example.demo.repository.FlightRepository;
import com.example.demo.service.FlightService;
import com.example.demo.service.dto.FlightsAndTotalCostDto;
import com.example.demo.service.dto.NumberOfFlightsPerDepartureGateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    //14.	Cho biết các chuyến bay có thể ñược thực hiện bởi máy bay Airbus A320.
    public List<String> findAllTheFlightsThatCanBeDoneByACertainTypeOfAirplane(String airplaneType)
    {
        return flightRepository.findAllTheFlightsThatCanBeDoneByACertainTypeOfAirplane(airplaneType);
    }

    // -- 17.	Giả sử một hành khách muốn đi thẳng từ ga A đến ga B rồi quay trở về ga A.
    // -- Cho biết các đường bay nào có thể đáp ứng yêu cầu này.
//    public List<String> listOfAllTheFlightFromAtoB(String departureGate, String arrivalGate)
//    {
//        List<String> listOfAllTheFlightIdHasTheSameDepartureGateAndArrivalGate = new ArrayList<>();
//        for (Flight firstFlight: flightRepository.findFlightByDepartureGateContainingAndArrivalGateContaining(departureGate,arrivalGate)
//             ) {
//            for (Flight secondFlight: flightRepository.findFlightByDepartureGateContainingAndArrivalGateContaining(departureGate, arrivalGate)
//                 ) {
//                if (firstFlight.getDepartureGate().equalsIgnoreCase(secondFlight.getArrivalGate()) && secondFlight.getDepartureGate().equalsIgnoreCase(firstFlight.getArrivalGate()))
//                {
//                    listOfAllTheFlightIdHasTheSameDepartureGateAndArrivalGate.add(firstFlight.getId());
//                }
//            }
//        }
//
//        for (int i = 0; i < flightRepository.findAll().size()-1; i++)
//        {
//            for (int j = 1; j < flightRepository.findAll().size()-1; j++)
//            {
//                if (flightRepository.findFlightByDepartureGateContainingAndArrivalGateContaining(departureGate,arrivalGate).get(i).getDepartureGate().equals(
//                        flightRepository.findFlightByDepartureGateContainingAndArrivalGateContaining(departureGate,arrivalGate).get(j).getArrivalGate()) &&
//                        flightRepository.findFlightByDepartureGateContainingAndArrivalGateContaining(departureGate,arrivalGate).get(j).getDepartureGate().equals(
//                                flightRepository.findFlightByDepartureGateContainingAndArrivalGateContaining(departureGate,arrivalGate).get(i).getArrivalGate())
//                )
//                {
//                    listOfAllTheFlightIdHasTheSameDepartureGateAndArrivalGate.add(flightRepository.findFlightByDepartureGateContainingAndArrivalGateContaining(departureGate,arrivalGate).get(i).getId());
//                }
//            }
//        }
//        return listOfAllTheFlightIdHasTheSameDepartureGateAndArrivalGate;
//    }

    public List<String> findFlightThatProvidesTwoWaysTickets(String departureGate, String arrivalGate)
    {
        return flightRepository.findFlightThatProvidesTwoWaysTickets(departureGate, arrivalGate);
    }

    //-- 18. Với mỗi ga có chuyến bay xuất phát từ đó
    //-- cho biết có bao nhiêu chuyến bay khởi hành từ ga đó.

    public List<NumberOfFlightsPerDepartureGateDto> findNumberOfFlightsPerDepartureGate()
    {
        return flightRepository.findNumberOfFlightsPerDepartureGate();
    }

    //-- 19. Với mỗi ga có chuyến  bay xuất phát từ đó cho biết tổng chi phí
    //-- phải trả cho phi công lái các chuyến bay khởi hành từ ga đó.

//    public List<FlightsAndTotalCostDto> calculateTotalCostForEachFlight()
//    {
//        return flightRepository.calculateTotalCostForEachFlight();
//    }
}
