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

    /*
    Al utilizar @DeleteMapping para indicar el valor con el cual se quiere hacer la peticion
    se debe hacer con un @PathVariable TipoDato nombreDato, no con un @RequestBody o fallara
    */
    @DeleteMapping("del/id/{id}")
    public String deleteEmployeeId(@PathVariable int id) {
        employeService.deleteEmployeeById(id);
        return "Employee deleted successfully";
    }

    @DeleteMapping("del/rut/{rut}")
    public String deleteEmployeeRut(@PathVariable String rut) {
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
