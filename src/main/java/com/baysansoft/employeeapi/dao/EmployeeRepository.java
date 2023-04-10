package com.baysansoft.employeeapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.baysansoft.employeeapi.entities.Employee;

// @RepositoryRestResource(path = "members") // this is optional for rest api path, default "employees"
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
