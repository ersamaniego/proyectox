package com.example.proyecto_x.api.controller;

import com.example.proyecto_x.api.entity.Entrada;
import com.example.proyecto_x.api.service.EntradaService;
import com.example.proyecto_x.api.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/entradas")
public class EntradaController {

    @Autowired
    private EntradaService entradaService;

    @Autowired
    private SequenceGeneratorService service;

    @GetMapping("/")
    public Collection<Entrada> traerEntradas() {
        return entradaService.traerEntradas();
    }

    @GetMapping(value="/{id}")
    public Optional<Entrada> traerEntradaPorId(@PathVariable("id") int id) {
        return entradaService.traerEntradaPorId(id);
    }

    @PostMapping("/agregarEntrada")
    public String agregarEntrada(@RequestBody Entrada entrada) {
        entrada.setId(service.generateSequence(Entrada.SEQUENCE_NAME));
        return entradaService.agregarEntrada(entrada);
    }

    @PostMapping(value="/editarEntrada/{id}")
    public String editarEntradaPorId(@PathVariable("id") int id, @RequestBody Entrada entrada) {
        return entradaService.editarEntradaPorId(id, entrada);
    }

    @GetMapping(value="/borrarEntrada/{id}")
    public String borrarEntradaPorId(@PathVariable("id") int id) {
        return entradaService.borrarEntradaPorId(id);
    }
}
