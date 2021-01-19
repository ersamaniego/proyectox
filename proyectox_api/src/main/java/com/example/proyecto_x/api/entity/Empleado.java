package com.example.proyecto_x.api.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@EqualsAndHashCode

@Data
@AllArgsConstructor
@Document(collection = "Empleado")
public class Empleado {

    @Transient
    public static final String SEQUENCE_NAME = "empleados_sequence";

    @Id
    @EqualsAndHashCode.Exclude private int id;

    private String nombre;
    private String apellido;
    private int dni;
    @EqualsAndHashCode.Exclude private String contrasenia;
    @EqualsAndHashCode.Exclude private String mail;
    @EqualsAndHashCode.Exclude private int rol;

}