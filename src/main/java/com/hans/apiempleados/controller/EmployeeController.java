package com.hans.apiempleados.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hans.apiempleados.model.Employee;
import com.hans.apiempleados.service.EmployeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    
    @Autowired
    private EmployeService employeService;

    @GetMapping
    public List<Employee> getEmployees() {
        return employeService.getAllEmployees();
    }

    @PostMapping
    public Employee postEmployee(@RequestBody Employee employee) {   
        return employeService.saveEmployee(employee);
    }

    @PostMapping("bulk")
    public List<Employee> postEmployees(@RequestBody List<Employee> employees) {
        return employeService.saveEmployees(employees);
    }

}
