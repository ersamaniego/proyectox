package com.example.proyecto_x.api.controller;

import com.example.proyecto_x.api.entity.Rol;
import com.example.proyecto_x.api.repository.RolRepository;
import com.example.proyecto_x.api.service.RolService;
import com.example.proyecto_x.api.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/roles")
public class RolController {
    @Autowired
    private RolService rolService;

    @Autowired
    private SequenceGeneratorService service;

    @GetMapping("/")
    public Collection<Rol> traerRoles() {
        return rolService.traerRoles();
    }

    @GetMapping(value="/{id}")
    public Optional<Rol> traerRolPorId(@PathVariable("id") int id) {
        return rolService.traerRolPorId(id);
    }


    @PostMapping("/agregarRol")
    public String agregarRol(@RequestBody Rol rol) {
        rol.setId(service.generateSequence(Rol.SEQUENCE_NAME));
        return rolService.agregarRol(rol);
    }

    @PostMapping(value="/editarRolPorId/{id}")
    public String editarRolPorId(@PathVariable("id") int id, @RequestBody Rol nuevo) {
        return rolService.editarRolPorId(id, nuevo);
    }

    @GetMapping(value="/borrarRol/{id}")
    public String borrarRolPorId(@PathVariable("id") int id) {
        return rolService.borrarRolPorId(id);
    }
}