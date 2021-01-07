package com.example.proyecto_x.api.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString

@Document(collection = "Empleado")
public class Empleado {

    @Transient
    public static final String SEQUENCE_NAME = "empleados_sequence";

    @Id
    private int id;

    private String nombre;
    private String apellido;
    private int dni;
    private String contrasenia;
    private String mail;
    private int rol;

}