package com.example.proyecto_x.api.repository;

import com.example.proyecto_x.api.entity.Horario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioRepository extends MongoRepository<Horario, Integer>{
    
}