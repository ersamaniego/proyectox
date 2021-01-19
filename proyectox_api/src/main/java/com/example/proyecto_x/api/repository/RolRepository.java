package com.example.proyecto_x.api.repository;

import com.example.proyecto_x.api.entity.Rol;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends MongoRepository<Rol, Integer> {

}
