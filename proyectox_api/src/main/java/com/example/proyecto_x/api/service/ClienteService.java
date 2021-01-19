package com.example.proyecto_x.api.service;

import com.example.proyecto_x.api.dao.ClienteDAO;
import com.example.proyecto_x.api.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteDAO clienteDAO;

    public Collection<Cliente> traerClientes() {
        return clienteDAO.traerClientes();
    }

    public String agregarCliente(Cliente cli) {
        if (clienteDAO.traerClientes().contains(cli)) {
            return "Error! El cliente ya existe en la base de datos.";
        } else {
            clienteDAO.agregarCliente(cli);
            return "Cliente con ID " + cli.getId() + " agregado con éxito!";
        }
    }

    public Optional<Cliente> traerClientePorId(int id) {
        return clienteDAO.traerClientePorId(id);
    }

    public String borrarClientePorId(int id) {
        if (clienteDAO.traerClientePorId(id).isEmpty()) {
            return "Error! El cliente NO existe en la base de datos.";
        } else {
            clienteDAO.borrarClientePorId(id);
            return "Cliente con ID " + id + " eliminado con éxito!";
        }
    }

    public String editarClientePorId(int id, Cliente cli) {
        if (clienteDAO.traerClientePorId(id).isEmpty()) {
            return "Error! El cliente NO existe en la base de datos.";
        } else {
            clienteDAO.editarClientePorId(id, cli);
            return "Cliente con id " + id + " actualizado con éxito!";
        }
    }
}