package com.example.demo.service;

import com.example.demo.entity.Employee;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> getAll();

    Employee saveEmployee(Employee employee);

    Optional<Employee> findEmployeeById(Integer id);

    void deleteEmployeeById(Integer id);

    //3.	Tìm các nhân viên có lương nhỏ hơn 10,000.
    public List<Employee> findEmployeeBySalaryLessThan(Integer salary);

    //8. Cho biết tổng số lương phải trả cho các nhân viên.
    public Integer totalSalary();


}
