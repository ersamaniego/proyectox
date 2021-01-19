package com.example.proyecto_x.api.controller;

import com.example.proyecto_x.api.entity.Entrada;
import com.example.proyecto_x.api.entity.Juego;
import com.example.proyecto_x.api.repository.JuegoRepository;
import com.example.proyecto_x.api.service.JuegoService;
import com.example.proyecto_x.api.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/juegos")
public class JuegoController {
    @Autowired
    private JuegoService juegoService;

    @Autowired
    private SequenceGeneratorService service;

    @GetMapping("/")
    public Collection<Juego> traerJuegos() {
        return juegoService.traerJuegos();
    }

    @GetMapping(value="/{id}")
    public Optional<Juego> traerJuegoPorId(@PathVariable("id") int id) {
        return juegoService.traerJuegoPorId(id);
    }

    @PostMapping("/agregarJuego")
    public String agregarJuego(@RequestBody Juego juego) {
        juego.setId(service.generateSequence(Juego.SEQUENCE_NAME));
        return juegoService.agregarJuego(juego);
    }

    @PostMapping(value="/editarJuego/{id}")
    public String editarJuegoPorId(@PathVariable("id") int id, @RequestBody Juego j) {
        return juegoService.editarJuegoPorId(id, j);
    }

    @GetMapping(value="/borrarJuego/{id}")
    public String borrarJuego(@PathVariable("id") int id) {
        return juegoService.borrarJuegoPorId(id);
    }



///////////////////////////////////////////////////////////////////////////////////////////////////////////

    // DE PRUEBA!
    @GetMapping(value="/agregarEmpleado/{idJuego}_{idEmpleado}")
    public String agregarEmpleado(@PathVariable("idJuego") int idJuego, @PathVariable int idEmpleado) {
        return juegoService.agregarEmpleado(idJuego, idEmpleado);
    }
}
