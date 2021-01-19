package com.example.proyecto_x.api.dao;

import com.example.proyecto_x.api.entity.Entrada;
import com.example.proyecto_x.api.repository.EntradaRepository;
import com.mongodb.client.model.Collation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.Collection;
import java.util.Optional;

@Component
public class EntradaDAO {
    @Autowired
    private EntradaRepository entradaRepo;

    public Collection<Entrada> traerEntradas() {
        return entradaRepo.findAll();
    }

    public Entrada agregarEntrada(Entrada entrada) {
        return entradaRepo.insert(entrada);
    }

    public Optional<Entrada> traerEntradaPorId(int id) {
        return entradaRepo.findById(id);
    }

    public Optional<Entrada> borrarEntradaPorId(int id) {
        Optional<Entrada> entrada = entradaRepo.findById(id);
        entrada.ifPresent(e -> entradaRepo.delete(e));

        return entrada;
    }

    public Optional<Entrada> editarEntradaPorId(int id, Entrada ent) {
        Optional<Entrada> entradaExistente = entradaRepo.findById(id);

        entradaExistente.ifPresent(e -> e.setFecha_emision(ent.getFecha_emision()));
        entradaExistente.ifPresent(e -> e.setHora_emision(ent.getHora_emision()));
        entradaExistente.ifPresent(e -> e.setCliente(ent.getCliente()));
        entradaExistente.ifPresent(e -> e.setJuego(ent.getJuego()));

        entradaExistente.ifPresent(e -> entradaRepo.save(e));
        return entradaExistente;
    }
}
