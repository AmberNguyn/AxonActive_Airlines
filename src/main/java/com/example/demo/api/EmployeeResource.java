package com.example.demo.api;

import com.example.demo.entity.Employee;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(EmployeeResource.PATH)
public class EmployeeResource {
    public final static String PATH = "/api/employee";

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getAll() {
        return ResponseEntity.ok(employeeService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        Employee employee = employeeService.findEmployeeById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Id not found")
                );
        return ResponseEntity.ok(employee);
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee createdEmployee = employeeService.saveEmployee(employee);
        return ResponseEntity.created(URI.create(EmployeeResource.PATH + "/" + createdEmployee.getEmployeeId())).body(createdEmployee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        Employee employee = employeeService.findEmployeeById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("id not found")
                );
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployeeById(@PathVariable(value = "id") Integer id,
                                                       @RequestBody Employee newEmployee) throws ResourceNotFoundException
    {
        Employee employeeUpdate = employeeService.findEmployeeById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Id not found")
                );
        employeeUpdate.setName(newEmployee.getName());
        employeeUpdate.setSalary(newEmployee.getSalary());

        Employee savedEmployee = employeeService.saveEmployee(employeeUpdate);
        return ResponseEntity.ok(savedEmployee);
    }
}
