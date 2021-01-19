package com.example.proyecto_x.api.dao;

import com.example.proyecto_x.api.entity.Empleado;
import com.example.proyecto_x.api.entity.Juego;
import com.example.proyecto_x.api.repository.EmpleadoRepository;
import com.example.proyecto_x.api.repository.JuegoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

@Component
public class JuegoDAO {

    @Autowired
    private JuegoRepository juegoRepo;

    @Autowired
    private EmpleadoRepository empleadoRepo;

    public Collection<Juego> traerJuegos() {
        return juegoRepo.findAll();
    }

    public Optional<Juego> traerJuegoPorId(int id) {
        return juegoRepo.findById(id);
    }

    public Juego agregarJuego(Juego juego) {
        return juegoRepo.insert(juego);
    }

    public Optional<Juego> borrarJuegoPorId(int id) {
        Optional<Juego> j = juegoRepo.findById(id);
        j.ifPresent(jg -> juegoRepo.delete(jg));

        return j;
    }

    public Optional<Juego> editarJuegoPorId(int id, Juego j) {
        Optional<Juego> jue = juegoRepo.findById(id);

        jue.ifPresent(jg -> jg.setNombre(j.getNombre()));
        jue.ifPresent(jg -> jg.setDescripcion(j.getDescripcion()));
        jue.ifPresent(jg -> jg.setPuntosRequeridos(j.getPuntosRequeridos()));
        jue.ifPresent(jg -> jg.setCupoMaximo(j.getCupoMaximo()));
        jue.ifPresent(jg -> jg.setDisponible(j.isDisponible()));

        jue.ifPresent(jg -> jg.setListaEmpleados(j.getListaEmpleados()));

        return jue;
    }

    public String agregarEmpleado(int idJuego, int idEmpleado) {
        Optional<Juego> jue = juegoRepo.findById(idJuego);
        Optional<Empleado> emp = empleadoRepo.findById(idEmpleado);

        if (jue.isPresent() && emp.isPresent()) {
            Juego _j = jue.get();
            Empleado _emp = emp.get();

            _j.getListaEmpleados().add(_emp);

            juegoRepo.save(_j);

            return "Empleado " + idEmpleado + " agregado con éxito!";
        } else {
            return "Ocurrió un problema al añadir el empleado al juego!";
        }
    }
}
