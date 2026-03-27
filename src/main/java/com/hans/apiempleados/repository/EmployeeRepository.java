package com.hans.apiempleados.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.hans.apiempleados.model.Employee;

import lombok.Data;

@Repository
@Data
public class EmployeeRepository {
    
    private List<Employee> empleados;

    public EmployeeRepository() {
        empleados = new ArrayList<>();
    }

    public Employee addEmployee(Employee empleado) {
        empleados.add(empleado);
        return empleado;
    }

    public List<Employee> getAllEmployees() {
        return empleados;
    }

    public Employee getEmpleadoById(int id) {
        return empleados.stream()
                .filter(empleado -> empleado.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Employee getEmpleadoByRut(String rut) {
        return empleados.stream()
                .filter(empleado -> empleado.getRut().equals(rut))
                .findFirst()
                .orElse(null);
    }


    public void removeEmployeeById(int id) {
        empleados.removeIf(empleado -> empleado.getId() == id);
    }

    public Employee updateEmployeeById(Employee empleado) {
        Employee existEmployee = getEmpleadoById(empleado.getId());
        if(existEmployee != null) {
            existEmployee.setPrimerNombre(empleado.getPrimerNombre());
            existEmployee.setSegundoNombre(empleado.getSegundoNombre());
            existEmployee.setPrimerApellido(empleado.getPrimerApellido());
            existEmployee.setSegundoApellido(empleado.getSegundoApellido());
            existEmployee.setEmail(empleado.getEmail());
            existEmployee.setTelefono(empleado.getTelefono());
            existEmployee.setDireccion(empleado.getDireccion());
            existEmployee.setContratoActivo(empleado.isContratoActivo());
            existEmployee.setFechaIngreso(empleado.getFechaIngreso());
            existEmployee.setFechaSalida(empleado.getFechaSalida());
            return existEmployee;
        } else {
            return null;
        }
    }

    public Employee updateEmployeeByRut(Employee empleado) {
        Employee existEmployee = getEmpleadoByRut(empleado.getRut());
        if(existEmployee != null) {
                        existEmployee.setPrimerNombre(empleado.getPrimerNombre());
            existEmployee.setSegundoNombre(empleado.getSegundoNombre());
            existEmployee.setPrimerApellido(empleado.getPrimerApellido());
            existEmployee.setSegundoApellido(empleado.getSegundoApellido());
            existEmployee.setEmail(empleado.getEmail());
            existEmployee.setTelefono(empleado.getTelefono());
            existEmployee.setDireccion(empleado.getDireccion());
            existEmployee.setContratoActivo(empleado.isContratoActivo());
            existEmployee.setFechaIngreso(empleado.getFechaIngreso());
            existEmployee.setFechaSalida(empleado.getFechaSalida());
            return existEmployee;
        } else {
            return null;
        }
    }
    
}
