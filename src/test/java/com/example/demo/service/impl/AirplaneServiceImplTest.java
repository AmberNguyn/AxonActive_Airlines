package com.example.demo.service.impl;

import com.example.demo.entity.Airplane;
import com.example.demo.service.AirplaneService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class AirplaneServiceImplTest {

    @Nested
    class TestCasesAfterSaved {
        @Autowired
        AirplaneService airplaneService;

        @BeforeEach
        void setup() {
            Airplane airplane1 = Airplane.builder()
                    .airplaneId(101)
                    .airplaneType("Boeing")
                    .flyingDistance(10000)
                    .build();
            airplaneService.saveAirplane(airplane1);

            Airplane airplane2 = Airplane.builder()
                    .airplaneId(102)
                    .airplaneType("Airbus")
                    .flyingDistance(12000)
                    .build();
            airplaneService.saveAirplane(airplane2);


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
            assertEquals(1, airplaneService.findHowManyAirplaneByAirplaneTypeContaining("ing"));
        }

        @Test
        void findHowManyAirplaneByAirplaneTypeContaining_shouldReturnZero_whenNotFound()
        {
            assertEquals(0, airplaneService.findHowManyAirplaneByAirplaneTypeContaining("dad"));
        }
    }

}