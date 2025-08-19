package com.developer.SpringBoot_Restapi_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.developer.SpringBoot_Restapi_project.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // No extra code needed for basic CRUD
}
