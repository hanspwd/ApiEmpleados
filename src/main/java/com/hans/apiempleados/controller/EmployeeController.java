package com.hans.apiempleados.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hans.apiempleados.model.Employee;
import com.hans.apiempleados.service.EmployeService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


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

    @DeleteMapping("{id}")
    public String deleteEmployeeId(@RequestBody int id) {
        employeService.deleteEmployeeById(id);
        return "Employee deleted successfully";
    }

    @DeleteMapping("{rut}")
    public String deleteEmployeeRut(@RequestBody String rut) {
        employeService.deleteEmployeeByRut(rut);
        return "Employee deleted successfully";
    }

    @PutMapping("{rut}")
    public Employee putEmployeeRut(@PathVariable String rut, @RequestBody Employee employee) {
        return employeService.updateEmployeeByRut(employee);
    }

    @PutMapping("{id}")
    public Employee putEmployeeRut(@PathVariable int id, @RequestBody Employee employee) {
        return employeService.updateEmployeeById(employee);
    }

}
