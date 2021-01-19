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
@Document(collection = "Horario")
public class Horario {

   @Transient
   public static final String SEQUENCE_NAME = "horarios_sequence";

   @Id
   @EqualsAndHashCode.Exclude private int id;
   
   private String hora_inicio;
   private String hora_fin;
   
}