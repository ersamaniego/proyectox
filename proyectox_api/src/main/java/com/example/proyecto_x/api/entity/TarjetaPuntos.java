package com.example.proyecto_x.api.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Getter
@Setter
@ToString

@Document(collection = "TarjetaPuntos")
public class TarjetaPuntos {
    @Transient
    public static final String SEQUENCE_NAME = "tarjetapuntos_sequence";

    @Id
    private int id;

    private String descripcion;
    private int puntosDisponibles;
    private LocalDate fecha_creacion;
    private boolean disponible;
}