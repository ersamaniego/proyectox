package com.example.proyecto_x.api.service;

import com.example.proyecto_x.api.dao.HorarioDAO;
import com.example.proyecto_x.api.entity.Horario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class HorarioService {
    @Autowired
    private HorarioDAO horarioDAO;

    public String agregarHorario(Horario nuevo) {
        if (horarioDAO.traerHorarios().contains(nuevo)) {
            return "Error! El horario ya existe en la base de datos.";
        } else {
            horarioDAO.agregarHorario(nuevo);
            return "Horario con ID " + nuevo.getId() + " agregado con éxito!";
        }
    }

    public Collection<Horario> traerHorarios() {
        return horarioDAO.traerHorarios();
    }

    public Optional<Horario> traerHorarioPorId(int id) {
        return horarioDAO.traerHorarioPorId(id);
    }

    public String borrarHorarioPorId(int id) {
        if (horarioDAO.traerHorarioPorId(id).isEmpty()) {
            return "Error! El horario no existe en la base de datos.";
        } else {
            horarioDAO.borrarHorarioPorId(id);
            return "Horario con ID " + id + " eliminado con éxito!";
        }
    }

    public String editarHorarioPorId(int id, Horario nuevo) {
        if (horarioDAO.traerHorarioPorId(id).isEmpty()) {
            return "Error! El horario no existe en la base de datos";
        } else {
            horarioDAO.editarHorarioPorId(id, nuevo);
            return "Horario con ID " + id + " actualizado con éxito!";
        }
    }
}
