package com.example.proyecto_x.api.dao;

import com.example.proyecto_x.api.entity.Horario;
import com.example.proyecto_x.api.repository.HorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

@Component
public class HorarioDAO {
    @Autowired
    private HorarioRepository horarioRepo;

    public Horario agregarHorario(Horario h) {
        return horarioRepo.insert(h);
    }

    public Collection<Horario> traerHorarios() {
        return horarioRepo.findAll();
    }

    public Optional<Horario> traerHorarioPorId(int id) {
        return horarioRepo.findById(id);
    }

    public Optional<Horario> borrarHorarioPorId(int id) {
        Optional<Horario> horario = horarioRepo.findById(id);

        horario.ifPresent(_h -> horarioRepo.delete(_h));

        return horario;
    }

    public Optional<Horario> editarHorarioPorId(int id, Horario horarioNuevo) {
        Optional<Horario> horarioAct = horarioRepo.findById(id);

        horarioAct.ifPresent(_h -> _h.setHora_inicio(horarioNuevo.getHora_inicio()));
        horarioAct.ifPresent(_h -> _h.setHora_fin(horarioNuevo.getHora_fin()));

        horarioAct.ifPresent(_h -> horarioRepo.save(_h));

        return horarioAct;
    }
}