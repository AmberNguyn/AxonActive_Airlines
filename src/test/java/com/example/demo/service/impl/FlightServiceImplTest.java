package com.example.demo.service.impl;

import com.example.demo.entity.Airplane;
import com.example.demo.entity.Flight;
import com.example.demo.service.AirplaneService;
import com.example.demo.service.FlightService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
class FlightServiceImplTest {


    @Nested
    class TestCasesAfterSave {
        @Autowired
        FlightService flightService;
        @Autowired
        AirplaneService airplaneService;


        @BeforeEach
        void setup() {
            Airplane airplane1 = Airplane.builder()
                    .id(101)
                    .type("Boeing")
                    .range(10000)
                    .build();
            airplaneService.saveAirplane(airplane1);

            Airplane airplane2 = Airplane.builder()
                    .id(102)
                    .type("Airbus")
                    .range(12000)
                    .build();
            airplaneService.saveAirplane(airplane2);

            Flight flight1 = Flight.builder()
                    .cost(1000)
                    .arrivalGate("DAD")
                    .departureGate("SGN")
                    .arrivalTime(LocalDate.of(2000, 10, 10))
                    .id("A760")
                    .distance(9500)
                    .departureTime(LocalDate.of(2000, 10, 9))
                    .build();
            flightService.saveFlight(flight1);

            Flight flight2 = Flight.builder()
                    .cost(900)
                    .arrivalTime(LocalDate.of(2000, 10, 15))
                    .arrivalGate("SGN")
                    .departureTime(LocalDate.of(2000, 10, 17))
                    .departureGate("DAD")
                    .distance(9000)
                    .id("A123")
                    .build();
            flightService.saveFlight(flight2);
        }


        @Test
        void findFlightByArrivalGateContaining_shouldReturnDaLat_WhenInputDAD() {
            List<Flight> flights = flightService.findFlightByArrivalGateContaining("DAD");
            assertEquals(1, flights.size());
        }

        @Test
        void findFlightByDistanceBetween_shouldReturnAListOfTwoFlights_whenFound() {
            List<Flight> flights = flightService.findFlightByDistanceBetween(8000, 10000);
            assertEquals(2, flights.size());
        }

        @Test
        void findFlightByDepartureGateAndArrivalGate_shouldReturnAFlight_whenDepartureGateIsDAdAndArrivalGateIsSGN() {
            List<Flight> flights = flightService.findFlightByDepartureGateAndArrivalGate("DAD", "SGN");
            assertEquals(1, flights.size());
        }


        @Test
        void findTheNumberOfFlightByDepartureGate_shouldReturnOneFlight_WhenFound() {
            assertEquals(1, flightService.findTheNumberOfFlightByDepartureGate("DAD"));
        }

        @Test
        void findTheNumberOfFlightByDepartureGate_shouldReturnZero_whenNotFound() {
            assertEquals(0, flightService.findTheNumberOfFlightByDepartureGate("HNN"));
        }

        @Test
        void findAllTheFlightsThatCanBeDoneByACertainTypeOfAirplane_shouldReturnAListOfTwoAirplanes_whenFound()
        {
            assertEquals(2, flightService.findAllTheFlightsThatCanBeDoneByACertainTypeOfAirplane("Boeing").size());
        }

        @Test
        void findFlightsThatProvidesTwoWaysTickets_shouldReturnAListOfTwo_whenFound()
        {
            assertEquals(2, flightService.findFlightThatProvidesTwoWaysTickets("SGN", "DAD").size());
        }

        //test 18
        @Test
        void fsd()
        {
            assertEquals(2, flightService.findNumberOfFlightsPerDepartureGate().size());
        }


        //test 19
    }


}