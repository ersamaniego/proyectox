package com.example.proyecto_x.api;

import java.util.List;
import java.util.Optional;
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
    
    @PostMapping("/agregarHorario")
    public String agregarHorario(@RequestBody Horario horario) {
        horarioRepo.save(horario);
        return "Horario con ID " + horario.getId() + " agregado con éxito!";
    }
    
    @GetMapping("/traerHorarios")
    public List<Horario> traerHorarios() {
        return horarioRepo.findAll();
    }
    
    @GetMapping("/traerHorarios/{id}")
    public Optional<Horario> traerLibro(@PathVariable int id) {
        return horarioRepo.findById(id);
    }
    
    @DeleteMapping("/borrar/{id}")
    public String borrarHorario(@PathVariable int id) {
        horarioRepo.deleteById(id);
        return "Horario con ID " + id + " eliminado con éxito!";
    }
}