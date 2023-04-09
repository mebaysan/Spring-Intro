package com.baysansoft.employeeapi.services;

import java.util.List;

import com.baysansoft.employeeapi.entities.Employee;

public interface EmployeeService {

    public List<Employee> findAll();

    public Employee save(Employee employee);

    public void deleteById(int id);

    public Employee findById(int id);
}
