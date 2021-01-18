package com.example.proyecto_x.api.service;

import com.example.proyecto_x.api.dao.JuegoDAO;
import com.example.proyecto_x.api.entity.Juego;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class JuegoService {

    @Autowired
    private JuegoDAO juegoDAO;

    public Collection<Juego> traerJuegos() {
        return juegoDAO.traerJuegos();
    }

    public Optional<Juego> traerJuegoPorId(int id) {
        return juegoDAO.traerJuegoPorId(id);
    }

    public String agregarJuego(Juego j) {
        if (juegoDAO.traerJuegos().contains(j)) {
            return "Error! El juego ya existe en la base de datos.";
        } else {
            juegoDAO.agregarJuego(j);
            return "El juego con ID " + j.getId() + " fue agregado con éxito!";
        }
    }

    public String borrarJuegoPorId(int id) {
        if (juegoDAO.traerJuegoPorId(id).isEmpty()) {
            return "Error! El juego no existe en la base de datos.";
        } else {
            juegoDAO.borrarJuegoPorId(id);
            return "Juego con ID " + id + " eliminado con éxito!";
        }
    }

    public String editarJuegoPorId(int id, Juego j) {
        if (juegoDAO.traerJuegoPorId(id).isEmpty()) {
            return "Error! El juego no existe en la base de datos.";
        } else {
            juegoDAO.editarJuegoPorId(id, j);
            return "Juego con ID " + id + " actualizado con éxito!";
        }
    }


    // de prueba!
    public String agregarEmpleado(int idJuego, int idEmpleado) {
        return juegoDAO.agregarEmpleado(idJuego, idEmpleado);
    }

}
