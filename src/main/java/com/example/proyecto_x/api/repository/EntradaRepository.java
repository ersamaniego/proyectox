package com.example.proyecto_x.api.repository;

import com.example.proyecto_x.api.entity.Entrada;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntradaRepository extends MongoRepository<Entrada, Integer> {

}
