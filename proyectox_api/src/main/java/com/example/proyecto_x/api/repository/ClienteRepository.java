package com.example.proyecto_x.api.repository;

import com.example.proyecto_x.api.entity.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends MongoRepository<Cliente, Integer> {

}
