package com.example.demo.service.impl;

import com.example.demo.entity.Flight;
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
    class casesAfterSave {
        @Autowired
        FlightService flightService;


        @BeforeEach
        void setup() {
            Flight flight1 = Flight.builder()
                    .cost(1000)
                    .arrivalGate("DAD")
                    .departureGate("SGN")
                    .arrivalTime(LocalDate.of(2000, 10, 10))
                    .flightID("A760")
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
                    .flightID("A123")
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

    }


}