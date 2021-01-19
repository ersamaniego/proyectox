package com.example.proyecto_x.api.controller;

import com.example.proyecto_x.api.entity.Empleado;
import com.example.proyecto_x.api.repository.EmpleadoRepository;
import com.example.proyecto_x.api.service.EmpleadoService;
import com.example.proyecto_x.api.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    private SequenceGeneratorService service;

    @GetMapping("/")
    public Collection<Empleado> traerEmpleados() {
        return empleadoService.traerEmpleados();
    }

    @GetMapping(value="/{id}")
    public Optional<Empleado> traerEmpleado(@PathVariable("id") int id) {
        return empleadoService.traerEmpleadoPorId(id);
    }

    @PostMapping("/agregarEmpleado")
    public String agregarEmpleado(@RequestBody Empleado empleado) {
        empleado.setId(service.generateSequence(Empleado.SEQUENCE_NAME));
        return empleadoService.agregarEmpleado(empleado);
    }

    @GetMapping(value="/borrarEmpleado/{id}")
    public String borrarEmpleadoPorId(@PathVariable("id") int id) {
        return empleadoService.borrarEmpleadoPorId(id);
    }

    @PostMapping(value="/editarEmpleado/{id}")
    public String editarEmpleadoPorId(@PathVariable("id") int id, @RequestBody Empleado empleado) {
        return empleadoService.editarEmpleadoPorId(id, empleado);
    }
}
