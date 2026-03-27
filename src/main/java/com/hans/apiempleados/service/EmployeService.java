package com.hans.apiempleados.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hans.apiempleados.model.Employee;
import com.hans.apiempleados.repository.EmployeeRepository;

@Service
public class EmployeService {
    
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    public Employee getEmployeeById(int id) {
        return employeeRepository.getEmpleadoById(id);
    }

    public Employee getEmployeeByRut(String rut) {
        return employeeRepository.getEmpleadoByRut(rut);
    }

    public Employee saveEmployee(Employee empleado) {
        return employeeRepository.addEmployee(empleado);
    }

    public void deleteEmployeeById(int id) {
        employeeRepository.removeEmployeeById(id);
    }

    public Employee updateEmployeeByRut(Employee empleado) {
        return employeeRepository.updateEmployeeByRut(empleado);
    }

}
