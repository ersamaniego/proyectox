package com.example.proyecto_x.api.service;

import com.example.proyecto_x.api.dao.EntradaDAO;
import com.example.proyecto_x.api.entity.Entrada;
import com.example.proyecto_x.api.repository.EntradaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class EntradaService {

    @Autowired
    private EntradaDAO entradaDAO;

    public Collection<Entrada> traerEntradas() {
        return entradaDAO.traerEntradas();
    }

    public String agregarEntrada(Entrada entrada) {
        if (entradaDAO.traerEntradas().contains(entrada)) {
            return "Error! La entrada ya existe en la base de datos.";
        } else {
            entradaDAO.agregarEntrada(entrada);
            return "La entrada con ID " + entrada.getId() + " fue agregada con éxito!";
        }
    }

    public Optional<Entrada> traerEntradaPorId(int id) {
        return entradaDAO.traerEntradaPorId(id);
    }

    public String borrarEntradaPorId(int id) {
        if (entradaDAO.traerEntradaPorId(id).isEmpty()) {
            return "Error! La entrada no existe en la base de datos.";
        } else {
            entradaDAO.borrarEntradaPorId(id);
            return "Entrada con ID " + id + " eliminada con éxito";
        }
    }

    public String editarEntradaPorId(int id, Entrada e) {
        if (entradaDAO.traerEntradaPorId(id).isEmpty()) {
            return "Error! La entrada no existe en la base de datos.";
        } else {
            entradaDAO.editarEntradaPorId(id, e);
            return "Entrada con ID " + id + " actualizada con éxito!";
        }
    }
}
