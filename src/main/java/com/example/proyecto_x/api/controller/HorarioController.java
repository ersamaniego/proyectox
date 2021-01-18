package com.example.proyecto_x.api.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.example.proyecto_x.api.entity.Horario;
import com.example.proyecto_x.api.repository.HorarioRepository;
import com.example.proyecto_x.api.service.HorarioService;
import com.example.proyecto_x.api.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/horarios")
public class HorarioController {

    @Autowired
    private HorarioService horarioService;

    @Autowired
    private SequenceGeneratorService service;

    @GetMapping("/")
    public Collection<Horario> traerHorarios() {
        return horarioService.traerHorarios();
    }

    @GetMapping("/{id}")
    public Optional<Horario> traerHorarioPorId(@PathVariable("id") int id) {
        return horarioService.traerHorarioPorId(id);
    }

    @PostMapping("/agregarHorario")
    public String agregarHorario(@RequestBody Horario horario) {
        horario.setId(service.generateSequence(Horario.SEQUENCE_NAME));
        return horarioService.agregarHorario(horario);
    }

    @GetMapping("/borrarHorario/{id}")
    public String borrarHorarioPorId(@PathVariable("id") int id) {
        return horarioService.borrarHorarioPorId(id);
    }

    @PostMapping("/editarHorario/{id}")
    public String editarHorarioPorId(@PathVariable("id") int id, @RequestBody Horario horario) {
        return horarioService.editarHorarioPorId(id, horario);
    }
}