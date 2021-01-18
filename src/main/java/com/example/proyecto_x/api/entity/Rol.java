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
@Document(collection = "Rol")
public class Rol {

    @Transient
    public static final String SEQUENCE_NAME = "roles_sequence";

    @Id
    @EqualsAndHashCode.Exclude private int id;

    private String nombre;
}
