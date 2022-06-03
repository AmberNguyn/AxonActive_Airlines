package com.example.demo.service.impl;

import com.example.demo.entity.Airplane;
import com.example.demo.entity.Certificate;
import com.example.demo.entity.Employee;
import com.example.demo.service.AirplaneService;
import com.example.demo.service.CertificateService;
import com.example.demo.service.EmployeeService;
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
class CertificateServiceImplTest {

    @Nested
    class TestCasesAfterSaved {
        @Autowired
        EmployeeService employeeService;
        @Autowired
        AirplaneService airplaneService;
        @Autowired
        CertificateService certificateService;


        @BeforeEach
        void setup() {
           Employee employee1 = Employee.builder()
                    .name("Anh Nguyen")
                    .employeeId(10030)
                    .salary(1500)
                    .build();
            employeeService.saveEmployee(employee1);

            Employee employee2 = Employee.builder()
                    .name("Tong Vu")
                    .employeeId(10031)
                    .salary(2000)
                    .build();
            employeeService.saveEmployee(employee2);



            Airplane airplane1 = Airplane.builder()
                    .type("Boeing")
                    .id(747)
                    .range(4000)
                    .build();
            airplaneService.saveAirplane(airplane1);

            Airplane airplane2 = Airplane.builder()
                    .type("Boeing")
                    .id(747)
                    .range(4000)
                    .build();
            airplaneService.saveAirplane(airplane2);

            Airplane airplane3 = Airplane.builder()
                    .type("Airbus")
                    .id(740)
                    .range(6000)
                    .build();
            airplaneService.saveAirplane(airplane3);


            Certificate certificate1 = Certificate.builder()
                    .airplane(airplane1)
                    .employee(employee1)
                    .build();
            certificateService.saveCertificate(certificate1);


            Certificate certificate2 = Certificate.builder()
                    .airplane(airplane2)
                    .employee(employee2)
                    .build();
            certificateService.saveCertificate(certificate2);

            Certificate certificate3 = Certificate.builder()
                    .airplane(airplane3)
                    .employee(employee1)
                    .build();
            certificateService.saveCertificate(certificate3);

        }

        @Test
        void findAllThePilotsWhoCanFlyATypeOfAirplane_shouldReturnAListOfTwoEmployee_WhenFound() {
            assertEquals(1, certificateService.findAllThePilotsWhoCanFlyATypeOfAirplane("Airbus").size());
        }

        @Test
        void findAllThePilotsWhoCanFlyATypeOfAirplane_shouldReturnAListOfZero_WhenNotFound() {
            assertEquals(0, certificateService.findAllThePilotsWhoCanFlyATypeOfAirplane("Helicopter").size());
        }

        @Test
        void findEmployeeByAirplaneAirplaneId_shouldReturnAListOfOneEmployee_whenFound() {
            assertEquals(1, certificateService.findEmployeeByAirplaneAirplaneId(740).size());
        }

        @Test
        void findAirplaneByEmployeeName_shouldReturnAListOfOneEmployee_whenFound() {
            assertEquals(2, certificateService.findAirplaneByEmployeeNameContaining("Nguyen").size());
        }

        @Test
        void findEmployeeByAirplaneAirplaneTypeContainingAndAirplaneAirplaneTypeContaining_shouldReturnAListOfOneEmployee_whenFound()
        {
            assertEquals(1, certificateService.findAllThePilotsWhoCanFlyTwoTypesOfAirplanes("Boeing", "Airbus").size());
        }

        @Test
        void findAllEmployeeByAirplaneTypeContaining_shouldReturnAListOfNames_whenFound()
        {
            assertEquals(2, certificateService.findPilotsByAirplaneTypeContaining("Boeing").size());
        }







}}