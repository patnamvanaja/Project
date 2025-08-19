package com.developer.SpringBoot_Restapi_project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.developer.SpringBoot_Restapi_project.entity.Employee;
import com.developer.SpringBoot_Restapi_project.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    // Fetch all employee records
    public List<Employee> getDetails() {
        return repo.findAll();
    }

    // Insert a new employee
    public Employee createEmployee(Employee emp) {
        return repo.save(emp);
    }

    // Get employee by ID
    public Optional<Employee> getDetailsById(long id) {
        return repo.findById(id);
    }

    // Delete employee by ID
    public void deleteDetailsById(long id) {
    
        repo.deleteById(id);
    }

}