package com.example.proyecto_x.api.resource;

import java.util.List;
import java.util.Optional;

import com.example.proyecto_x.api.model.Horario;
import com.example.proyecto_x.api.repository.HorarioRepository;
import com.example.proyecto_x.api.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HorarioController {


    @Autowired
    private HorarioRepository horarioRepo;

    @Autowired
    private SequenceGeneratorService service;

    @PostMapping("/agregarHorario")
    public String agregarHorario(@RequestBody Horario horario) {
        horario.setId(service.generateSequence(Horario.SEQUENCE_NAME));
        horarioRepo.save(horario);
        return "Horario con ID " + horario.getId() + " agregado con éxito!";
    }
    
    @GetMapping("/traerHorarios")
    public List<Horario> traerHorarios() {
        return horarioRepo.findAll();
    }
    
    @GetMapping("/traerHorario/{id}")
    public Optional<Horario> traerHorario(@PathVariable int id) {
        return horarioRepo.findById(id);
    }
    
    @GetMapping("/borrarHorario/{id}")
    public String borrarHorario(@PathVariable int id) {
        horarioRepo.deleteById(id);
        return "Horario con ID " + id + " eliminado con éxito!";
    }
}