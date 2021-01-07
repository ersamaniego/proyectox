package com.example.proyecto_x.api.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@ToString

@Document(collection = "Juego")
public class Juego {
    @Transient
    public static final String SEQUENCE_NAME = "juegos_sequence";

    @Id
    private int id;

    private String nombre;
    private String descripcion;
    private int puntosRequeridos;
    private int cupoMaximo;
    private boolean disponible;

    private List<Empleado> listaEmpleados;
}
