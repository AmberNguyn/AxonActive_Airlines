package com.example.demo.repository;

import com.example.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //3.	Tìm các nhân viên có lương nhỏ hơn 10,000.
    List<Employee> findEmployeeBySalaryLessThan(Integer salary);

    //8. Cho biết tổng số lương phải trả cho các nhân viên.
    @Query(value = "SELECT SUM(salary) FROM Employee", nativeQuery = true)
    Integer totalSalary();


}
