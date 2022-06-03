package com.example.demo.service.impl;

import com.example.demo.entity.Certificate;
import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.CertificateService;
import com.example.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service

public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    CertificateService certificateService;

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> findEmployeeById(Integer id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void deleteEmployeeById(Integer id) {
        employeeRepository.deleteById(id);
    }

    //3.	Tìm các nhân viên có lương nhỏ hơn 10,000.
    @Override
    public List<Employee> findEmployeeBySalaryLessThan(Integer salary) {
        return employeeRepository.findEmployeeBySalaryLessThan(salary);
    }

    //8. Cho biết tổng số lương phải trả cho các nhân viên.
    public Integer totalSalary() {
        return employeeRepository.totalSalary();
    }

    //15.
    public List<Employee> allEmployees() {
        return employeeRepository.findAll();
    }


    public List<String> findNameOfAllTheEmployeesWhoCanFindACertainTypeofAirplane(String airplaneType) {
        List<String> nameOfAllTheEmployeesWhoCanFlyACertainTypeOfAirplane = new ArrayList<>();
        for (Employee employee:allEmployees())
         {
            for (Certificate employeeHasCertificate : certificateService.findPilotsByAirplaneTypeContaining(airplaneType))
            {
                if (employeeHasCertificate.getEmployee().getEmployeeId().equals(employee.getEmployeeId())) {
                    nameOfAllTheEmployeesWhoCanFlyACertainTypeOfAirplane.add(employee.getName());
                }
            }
        }
        return nameOfAllTheEmployeesWhoCanFlyACertainTypeOfAirplane;
    }


}
