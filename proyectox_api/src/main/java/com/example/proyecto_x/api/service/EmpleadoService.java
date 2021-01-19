package com.example.proyecto_x.api.service;

import com.example.proyecto_x.api.dao.EmpleadoDAO;
import com.example.proyecto_x.api.entity.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class EmpleadoService {
    @Autowired
    private EmpleadoDAO empleadoDAO;

    public Collection<Empleado> traerEmpleados() {
        return empleadoDAO.traerEmpleados();
    }

    public Optional<Empleado> traerEmpleadoPorId(int id) {
        return empleadoDAO.traerEmpleadoPorId(id);
    }

    public String agregarEmpleado(Empleado e) {
        if (empleadoDAO.traerEmpleados().contains(e)) {
            return "Error! El empleado ya existe en la base de datos.";
        } else {
            empleadoDAO.agregarEmpleado(e);
            return "Empleado con ID " + e.getId() + " agregado con éxito!";
        }
    }

    public String borrarEmpleadoPorId(int id) {
        if (empleadoDAO.traerEmpleadoPorId(id).isEmpty()) {
            return "Error! El empleado no existe en la base de datos.";
        } else {
            empleadoDAO.borrarClientePorId(id);
            return "Empleado con id " + id + " borrado con éxito!";
        }
    }

    public String editarEmpleadoPorId(int id, Empleado e) {
        if (empleadoDAO.traerEmpleadoPorId(id).isEmpty()) {
            return "Error! El empleado no existe en la base de datos.";
        } else {
            empleadoDAO.editarClientePorId(id, e);
            return "Empleado con id " + id + " actualizado con éxito!";
        }
    }
}