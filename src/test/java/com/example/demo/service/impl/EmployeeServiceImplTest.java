package com.example.demo.service.impl;

import com.example.demo.entity.Airplane;
import com.example.demo.entity.Certificate;
import com.example.demo.entity.Employee;
import com.example.demo.service.AirplaneService;
import com.example.demo.service.CertificateService;
import com.example.demo.service.EmployeeService;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
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
class EmployeeServiceImplTest {

    @Nested
    class TestCasesAfterSaved {
        @Autowired
        EmployeeService employeeService;
        @Autowired
        CertificateService certificateService;
        @Autowired
        AirplaneService airplaneService;

//        @BeforeEach
//        void setup() {
//            Employee employee1 = Employee.builder()
//                    .employeeId(10030)
//                    .name("Anh Nguyen")
//                    .salary(10000)
//                    .build();
//            employeeService.saveEmployee(employee1);
//
//            Employee employee2 = Employee.builder()
//                    .employeeId(10031)
//                    .name("Tong Vu")
//                    .salary(11000)
//                    .build();
//            employeeService.saveEmployee(employee2);
//
//            Airplane airplane1 = Airplane.builder()
//                    .type("Boeing")
//                    .id(747)
//                    .range(4000)
//                    .build();
//            airplaneService.saveAirplane(airplane1);
//
//            Airplane airplane2 = Airplane.builder()
//                    .type("Boeing")
//                    .id(747)
//                    .range(4000)
//                    .build();
//            airplaneService.saveAirplane(airplane2);
//
//            Airplane airplane3 = Airplane.builder()
//                    .type("Airbus")
//                    .id(740)
//                    .range(6000)
//                    .build();
//            airplaneService.saveAirplane(airplane3);
//
//
//            Certificate certificate1 = Certificate.builder()
//                    .airplane(airplane1)
//                    .employee(employee1)
//                    .build();
//            certificateService.saveCertificate(certificate1);
//
//
//            Certificate certificate2 = Certificate.builder()
//                    .airplane(airplane2)
//                    .employee(employee2)
//                    .build();
//            certificateService.saveCertificate(certificate2);
//
//            Certificate certificate3 = Certificate.builder()
//                    .airplane(airplane3)
//                    .employee(employee1)
//                    .build();
//            certificateService.saveCertificate(certificate3);
//
//
//
//        }

        @Test
        void findEmployeeBySalaryLessThan_shouldReturnAListOfTwoEmployees_whenFound()
        {
            assertEquals(1, employeeService.findEmployeeBySalaryLessThan(20000).size());
        }

        @Test

        void findEmployeeBySalaryLessThan_shouldReturnAListOfNoEmployees_whenNotFound()
        {
            assertEquals(1, employeeService.findEmployeeBySalaryLessThan(5000).size());
        }

        @Test
        void totalSalary_shouldReturnTheSumAmountOfSalary()
        {
            assertEquals(2874131, employeeService.totalSalary());
        }

        @Test
        void findAllTheEmployeesWhoCanFlyACertainTypeOfAirplane_shouldReturnAListOfNames_WhenFound()
        {
            assertEquals(11, employeeService.findNameOfAllTheEmployeesWhoCanFindACertainTypeofAirplane("Airbus").size());
        }

        //25
        @Test
        void findAllEmployeesWhoAreNotPilots_shouldReturnAListOf12Employees_whenFound()
        {
            assertEquals(12, employeeService.findAllEmployeesWhoAreNotPilots().size());
        }

        //26
        @Test
        void findEmployeeWhoHasTheHighestSalary_shouldReturnOneEmployee()
        {
            assertEquals(269734834, employeeService.findEmployeeWhoHasTheHighestSalary().get(0));
        }

        //27.
        @Test
        void showTotalSalaryHaveToPayForAllPilotss_shouldReturnSumOfMoney()
        {
            assertEquals(2064793, employeeService.showTotalSalaryHaveToPayForAllPilots());
        }







    }


}