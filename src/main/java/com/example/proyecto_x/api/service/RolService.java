package com.example.proyecto_x.api.service;

import com.example.proyecto_x.api.dao.RolDAO;
import com.example.proyecto_x.api.entity.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class RolService {
    @Autowired
    private RolDAO rolDAO;

    public String agregarRol(Rol nuevo) {
        rolDAO.agregarRol(nuevo);
        return "Rol con ID " + nuevo.getId() + " agregado con éxito!";
    }

    public Collection<Rol> traerRoles() {
        return rolDAO.traerRoles();
    }

    public Optional<Rol> traerRolPorId(int id) {
        return rolDAO.traerRolPorId(id);
    }

    public String borrarRolPorId(int id) {
        if (rolDAO.traerRolPorId(id).isEmpty()) {
            return "Error! El rol no existe en la base de datos.";
        } else {
            rolDAO.borrarRolPorId(id);
            return "Rol con ID " + id + " eliminado con éxito!";
        }
    }

    public String editarRolPorId(int id, Rol nuevo) {
        if (rolDAO.traerRolPorId(id).isEmpty()) {
            return "Error! El rol no existe en la base de datos.";
        } else {
            rolDAO.editarRolPorId(id, nuevo);
            return "Rol con ID " + id + " actualizado con éxito!";
        }
    }
}