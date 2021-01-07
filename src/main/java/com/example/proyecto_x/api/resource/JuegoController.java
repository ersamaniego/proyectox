package com.example.proyecto_x.api.resource;

import com.example.proyecto_x.api.model.Horario;
import com.example.proyecto_x.api.model.Juego;
import com.example.proyecto_x.api.repository.HorarioRepository;
import com.example.proyecto_x.api.repository.JuegoRepository;
import com.example.proyecto_x.api.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class JuegoController {
    @Autowired
    private JuegoRepository juegoRepo;

    @Autowired
    private SequenceGeneratorService service;

    @PostMapping("/agregarJuego")
    public String agregarJuego(@RequestBody Juego juego) {
        juego.setId(service.generateSequence(Juego.SEQUENCE_NAME));
        juegoRepo.save(juego);
        return "Juego con ID " + juego.getId() + " agregado con éxito!";
    }

    @GetMapping("/traerJuegos")
    public List<Juego> traerJuegos() {
        return juegoRepo.findAll();
    }

    @GetMapping("/traerJuego/{id}")
    public Optional<Juego> traerJuego(@PathVariable int id) {
        return juegoRepo.findById(id);
    }

    @GetMapping("/borrarJuego/{id}")
    public String borrarJuego(@PathVariable int id) {
        juegoRepo.deleteById(id);
        return "Juego con ID " + id + " eliminado con éxito!";
    }
}
