package com.example.proyecto_x.api.dao;

import com.example.proyecto_x.api.entity.Rol;
import com.example.proyecto_x.api.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

@Component
public class RolDAO {
    @Autowired
    private RolRepository rolRepo;

    public Rol agregarRol(Rol nuevoRol) {
        return rolRepo.insert(nuevoRol);
    }

    public Collection<Rol> traerRoles() {
        return rolRepo.findAll();
    }

    public Optional<Rol> traerRolPorId(int id) {
        return rolRepo.findById(id);
    }

    public Optional<Rol> borrarRolPorId(int id) {
        Optional<Rol> _rol = rolRepo.findById(id);

        _rol.ifPresent(r -> rolRepo.delete(r));

        return _rol;
    }

    public Optional<Rol> editarRolPorId(int id, Rol nuevoRol) {
        Optional<Rol> _rol = rolRepo.findById(id);

        _rol.ifPresent(r -> r.setNombre(nuevoRol.getNombre()));
        _rol.ifPresent(r -> rolRepo.save(r));

        return _rol;
    }

}
