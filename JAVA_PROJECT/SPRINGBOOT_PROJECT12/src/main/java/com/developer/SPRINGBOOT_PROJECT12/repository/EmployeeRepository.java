package com.developer.SPRINGBOOT_PROJECT12.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.developer.SPRINGBOOT_PROJECT12.Entity.EmployeeDetails;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeDetails, Long> {
    // No extra code needed for basic CRUD
}
