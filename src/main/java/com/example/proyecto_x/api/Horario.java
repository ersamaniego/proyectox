package com.example.proyecto_x.api;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString

@Document(collection = "Horario")
public class Horario {
    
   @Id
   private int id;
   
   private String hora_inicio;
   private String hora_fin;
   
}