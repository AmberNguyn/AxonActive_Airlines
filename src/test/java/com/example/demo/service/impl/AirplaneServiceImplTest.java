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

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class AirplaneServiceImplTest {

    @Nested
    class TestCasesAfterSaved {
        @Autowired
        AirplaneService airplaneService;
        @Autowired
        FlightService flightService;

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
        void findAirplaneByFlyingDistanceGreaterThan_shouldReturnAListOfTwo_whenFound()
        {
            assertEquals(2, airplaneService.findAirplaneByFlyingDistanceGreaterThan(9000).size());
        }

        @Test
        void findAirplaneByFlyingDistanceGreaterThan_shouldReturnZero_whenNotFound()
        {
            assertEquals(0, airplaneService.findAirplaneByFlyingDistanceGreaterThan(15000).size());
        }

        @Test
        void findHowManyAirplaneByAirplaneTypeContaining_shouldReturnOne_whenFound()
        {
            assertEquals(1, airplaneService.findHowManyAirplaneByTypeContaining("ing"));
        }

        @Test
        void findHowManyAirplaneByAirplaneTypeContaining_shouldReturnZero_whenNotFound()
        {
            assertEquals(0, airplaneService.findHowManyAirplaneByTypeContaining("dad"));
        }

        @Test
        void findAirplaneThatCanSatisfyACertainFlight_shouldReturnAListOfAirplane_whenFound()
        {
            assertEquals(2, airplaneService.findAirplaneThatCanSatisfyACertainFlight("A760").size());
        }

        @Test
        void listOfAirplaneIdAndAirplaneTypeAndNumberOfPilotsWhoCanFlyThem_shouldReturnNoData_WhenNotFound()
        {
            assertEquals(0, airplaneService.listOfAirplaneIdAndAirplaneTypeAndNumberOfPilotsWhoCanFlyThem().size());
        }


    }

}