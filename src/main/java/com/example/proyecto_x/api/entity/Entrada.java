package com.example.proyecto_x.api.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@ToString
@EqualsAndHashCode

@Data
@AllArgsConstructor
@Document(collection = "Entrada")
public class Entrada {

    @Transient
    public static final String SEQUENCE_NAME = "entradas_sequence";

    @Id
    @EqualsAndHashCode.Exclude private int id;

    private LocalDate fecha_emision;
    private LocalTime hora_emision;

    private Cliente cliente;
    private Juego juego;
}
