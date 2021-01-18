package com.example.proyecto_x.api.controller;

import com.example.proyecto_x.api.entity.Cliente;
import com.example.proyecto_x.api.repository.ClienteRepository;
import com.example.proyecto_x.api.service.ClienteService;
import com.example.proyecto_x.api.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @Autowired
    private SequenceGeneratorService service;

    @GetMapping("/")
    public Collection<Cliente> traerClientes() {
        return clienteService.traerClientes();
    }

    @GetMapping("/{id}")
    public Optional<Cliente> traerClientePorId(@PathVariable("id") int id) {
        return clienteService.traerClientePorId(id);
    }


    @PostMapping("/agregarCliente")
    public String agregarCliente(@RequestBody Cliente cliente) {
        cliente.setId(service.generateSequence(Cliente.SEQUENCE_NAME));
        return clienteService.agregarCliente(cliente);
    }

    @GetMapping("/borrarCliente/{id}")
    public String borrarClientePorId(@PathVariable("id") int id) {
        return clienteService.borrarClientePorId(id);
    }

    @PostMapping("/editarCliente/{id}")
    public String editarClientePorId(@PathVariable("id") int id, @RequestBody Cliente cliente) {
        return clienteService.editarClientePorId(id, cliente);
    }
}
