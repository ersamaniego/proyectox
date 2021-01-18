package com.example.proyecto_x.api.entity;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode

@Data
@AllArgsConstructor
@Document(collection = "Juego")
public class Juego {
    @Transient
    public static final String SEQUENCE_NAME = "juegos_sequence";

    @Id
    @EqualsAndHashCode.Exclude private int id;

    private String nombre;
    private String descripcion;
    @EqualsAndHashCode.Exclude private int puntosRequeridos;
    @EqualsAndHashCode.Exclude private int cupoMaximo;
    @EqualsAndHashCode.Exclude private boolean disponible;

    @EqualsAndHashCode.Exclude private List<Empleado> listaEmpleados;
}
