package com.example.proyecto_x.api.resource;

import com.example.proyecto_x.api.model.Empleado;
import com.example.proyecto_x.api.model.Horario;
import com.example.proyecto_x.api.repository.EmpleadoRepository;
import com.example.proyecto_x.api.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmpleadoController {

    @Autowired
    private EmpleadoRepository empleadoRepo;

    @Autowired
    private SequenceGeneratorService service;

    @PostMapping("/agregarEmpleado")
    public String agregarEmpleado(@RequestBody Empleado empleado) {
        empleado.setId(service.generateSequence(Empleado.SEQUENCE_NAME));
        empleadoRepo.save(empleado);
        return "Empleado con ID " + empleado.getId() + " agregado con éxito!";
    }

    @GetMapping("/traerEmpleados")
    public List<Empleado> traerEmpleados() {
        return empleadoRepo.findAll();
    }

    @GetMapping("/traerEmpleado/{id}")
    public Optional<Empleado> traerEmpleado(@PathVariable int id) {
        return empleadoRepo.findById(id);
    }

    @GetMapping("/borrarEmpleado/{id}")
    public String borrarEmpleado(@PathVariable int id) {
        empleadoRepo.deleteById(id);
        return "Empleado con ID " + id + " eliminado con éxito!";
    }
}
