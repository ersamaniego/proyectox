package com.example.proyecto_x.api.dao;

import com.example.proyecto_x.api.entity.Cliente;
import com.example.proyecto_x.api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.Collection;
import java.util.Optional;

@Component
public class ClienteDAO {

    @Autowired
    private ClienteRepository clienteRepo;

    public Collection<Cliente> traerClientes() {
        return clienteRepo.findAll();
    }

    public Cliente agregarCliente(Cliente c) {
        return clienteRepo.insert(c);
    }

    public Optional<Cliente> traerClientePorId(int id) {
        return clienteRepo.findById(id);
    }

    public Optional<Cliente> borrarClientePorId(int id) {
        Optional<Cliente> c = clienteRepo.findById(id);
        c.ifPresent(cli -> clienteRepo.delete(cli));

        return c;
    }

    public Optional<Cliente> editarClientePorId(int id, Cliente nuevo) {
        Optional<Cliente> cli = clienteRepo.findById(id);

        cli.ifPresent(_c -> _c.setNombre(nuevo.getNombre()));
        cli.ifPresent(_c -> _c.setApellido(nuevo.getApellido()));
        cli.ifPresent(_c -> _c.setDni(nuevo.getDni()));
        cli.ifPresent(_c -> _c.setContrasenia(nuevo.getContrasenia()));
        cli.ifPresent(_c -> _c.setMail(nuevo.getMail()));
        cli.ifPresent(_c -> _c.setRol(nuevo.getRol()));

        cli.ifPresent(_c -> _c.setTarjetaPuntos(nuevo.getTarjetaPuntos()));

        cli.ifPresent(_c -> clienteRepo.save(_c));

        return cli;
    }

}