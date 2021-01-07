package com.example.proyecto_x.api.repository;

import com.example.proyecto_x.api.model.Juego;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JuegoRepository extends MongoRepository<Juego, Integer> {

}