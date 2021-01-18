package com.example.proyecto_x.api.dao;

import com.example.proyecto_x.api.entity.Empleado;
import com.example.proyecto_x.api.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

@Component
public class EmpleadoDAO {
    @Autowired
    private EmpleadoRepository empleadoRepo;

    public Collection<Empleado> traerEmpleados() {
        return empleadoRepo.findAll();
    }

    public Optional<Empleado> traerEmpleadoPorId(int id) {
        return empleadoRepo.findById(id);
    }

    public Empleado agregarEmpleado(Empleado e) {
        return empleadoRepo.insert(e);
    }

    public Optional<Empleado> borrarClientePorId(int id) {
        Optional<Empleado> e = empleadoRepo.findById(id);
        e.ifPresent(_e -> empleadoRepo.delete(_e));

        return e;
    }

    public Optional<Empleado> editarClientePorId(int id, Empleado e) {
        Optional<Empleado> emp = empleadoRepo.findById(id);

        emp.ifPresent(_emp -> _emp.setNombre(e.getNombre()));
        emp.ifPresent(_emp -> _emp.setApellido(e.getApellido()));
        emp.ifPresent(_emp -> _emp.setDni(e.getDni()));
        emp.ifPresent(_emp -> _emp.setContrasenia(e.getContrasenia()));
        emp.ifPresent(_emp -> _emp.setMail(e.getMail()));
        emp.ifPresent(_emp -> _emp.setRol(e.getRol()));

        emp.ifPresent(_emp -> empleadoRepo.save(_emp));

        return emp;
    }
}
