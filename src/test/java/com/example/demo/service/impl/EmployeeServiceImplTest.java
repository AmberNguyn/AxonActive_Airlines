package com.example.demo.service.impl;

import com.example.demo.entity.Employee;
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
class EmployeeServiceImplTest {

    @Nested
    class TestCasesAfterSaved {
        @Autowired
        EmployeeService employeeService;

        @BeforeEach
        void setup() {
            Employee employee1 = Employee.builder()
                    .employeeId(10030)
                    .name("Anh Nguyen")
                    .salary(10000)
                    .build();
            employeeService.saveEmployee(employee1);

            Employee employee2 = Employee.builder()
                    .employeeId(10031)
                    .name("Tong Vu")
                    .salary(11000)
                    .build();
            employeeService.saveEmployee(employee2);

        }

        @Test
        void findEmployeeBySalaryLessThan_shouldReturnAListOfTwoEmployees_whenFound()
        {
            assertEquals(2, employeeService.findEmployeeBySalaryLessThan(20000).size());
        }

        @Test
        void findEmployeeBySalaryLessThan_shouldReturnAListOfNoEmployees_whenNotFound()
        {
            assertEquals(0, employeeService.findEmployeeBySalaryLessThan(5000).size());
        }

        @Test
        void totalSalary_shouldReturnTheSumAmountOfSalary()
        {
            assertEquals(21000, employeeService.totalSalary());
        }
    }


}