package com.developer.SpringBoot_Restapi_project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.developer.SpringBoot_Restapi_project.entity.Employee;
import com.developer.SpringBoot_Restapi_project.service.EmployeeService;

@RestController
@RequestMapping("/api/v1/employee") // static URL -- cannot be changed
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    // Get all employee details
    @GetMapping
    public List<Employee> getEmployeeDetails() {
        return service.getDetails();
    }

    // Create a new employee record
    @PostMapping
    public Employee createEmployeeDetails(@RequestBody Employee emp) {
        return service.createEmployee(emp);
    }

    // Get employee details by ID
    @GetMapping("/{empId}")
    public Optional<Employee> getEmployeeDetailsById(@PathVariable("empId") long id) {
        return service.getDetailsById(id);
    }

    // Delete employee by ID
    @DeleteMapping("/{empId}")
    public void deleteEmployeeById(@PathVariable("empId") long id) {
        service.deleteDetailsById(id);
    }
}
