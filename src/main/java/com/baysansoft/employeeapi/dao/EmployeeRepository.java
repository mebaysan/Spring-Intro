package com.baysansoft.employeeapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.baysansoft.employeeapi.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    
}
