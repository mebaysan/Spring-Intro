package com.baysansoft.employeeapi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baysansoft.employeeapi.entities.Employee;
import com.baysansoft.employeeapi.exceptions.EmployeeNotFoundError;
import com.baysansoft.employeeapi.services.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {

    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public List<Employee> findAllEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/{employeeId}")
    public Employee findEmployeeById(@PathVariable int employeeId) {
        Employee employee = employeeService.findById(employeeId);

        if (employee == null) {
            throw new EmployeeNotFoundError("Employee id not found - " + employeeId);
        }

        return employee;
    }

    @PostMapping("/")
    public Employee createEmployee(@RequestBody Employee employee) {
        employee.setId(0); // force a save instead of update
        Employee dbEmployee = employeeService.save(employee);
        return dbEmployee;
    }

    @DeleteMapping("/{employeeId}")
    public String deleteEmployeeById(@PathVariable int employeeId) {
        Employee employee = employeeService.findById(employeeId);

        if (employee == null) {
            throw new EmployeeNotFoundError("Employee id not found - " + employeeId);
        }

        employeeService.deleteById(employeeId);

        String msg = "Deleted employee id - " + employeeId;
        return "{\"message\": \"" + msg + "\"}";
    }

    @PutMapping("/")
    public Employee updateEmployee(@RequestBody Employee employee) {
        Employee dbEmployee = employeeService.save(employee);
        return dbEmployee;
    }
}
