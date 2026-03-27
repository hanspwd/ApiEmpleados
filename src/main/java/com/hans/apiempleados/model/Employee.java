package com.hans.apiempleados.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private int id;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String email;
    private String rut;
    private String telefono;
    private String direccion;
    private boolean contratoActivo;
    private Date fechaIngreso;
    private Date fechaSalida;
    
}
