package com.example.proyecto_x.api;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface HorarioRepository extends MongoRepository<Horario, Integer>{
    
}