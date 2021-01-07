package com.example.proyecto_x.api.resource;

import com.example.proyecto_x.api.model.Rol;
import com.example.proyecto_x.api.repository.RolRepository;
import com.example.proyecto_x.api.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RolController {
    @Autowired
    private RolRepository rolRepo;

    @Autowired
    private SequenceGeneratorService service;

    @PostMapping("/agregarRol")
    public String agregarRol(@RequestBody Rol rol) {
        rol.setId(service.generateSequence(Rol.SEQUENCE_NAME));
        rolRepo.save(rol);
        return "Rol con ID " + rol.getId() + " agregado con éxito!";
    }

    @GetMapping("/traerRoles")
    public List<Rol> traerRoles() {
        return rolRepo.findAll();
    }

    @GetMapping("/traerRol/{id}")
    public Optional<Rol> traerRol(@PathVariable int id) {
        return rolRepo.findById(id);
    }

    @GetMapping("/borrarRol/{id}")
    public String borrarRol(@PathVariable int id) {
        rolRepo.deleteById(id);
        return "Rol con ID " + id + " eliminado con éxito!";
    }
}
