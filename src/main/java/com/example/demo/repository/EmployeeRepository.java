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


    //15. Cho biết tên của các phi công lái máy bay Boeing.



    // 25. Tìm các nhân viên không phải là phi công.
    @Query(value = "SELECT e.employeeId " +
            "FROM Employee e " +
            "WHERE e.employeeId NOT IN " +
            "(SELECT c.employee.employeeId " +
            "FROM Certificate c)")
    List<Integer> findAllEmployeesWhoAreNotPilots();

    //-- 26. Show id of employees who have the highest salary
    @Query(value = "SELECT e.employeeId FROM Employee e " +
            "WHERE salary = (SELECT MAX(salary) FROM Employee)")
    List<Integer> findEmployeeWhoHasTheHighestSalary();


    // 27.Show total salary have to pay for all the pilots

    @Query (value = "SELECT SUM(e.salary) FROM Employee e WHERE e.employeeId IN" +
            " (SELECT c.employee.employeeId FROM Certificate c)")
    int showTotalSalaryHaveToPayForAllPilots();

}
