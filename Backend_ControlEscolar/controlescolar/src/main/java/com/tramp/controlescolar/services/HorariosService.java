package com.tramp.controlescolar.services;

import com.tramp.controlescolar.models.catalogos.Horarios;
import com.tramp.controlescolar.repository.HorariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorariosService {
    @Autowired
    private HorariosRepository horariosRepository;

    public List<Horarios> mostrarHorarios() {
        return horariosRepository.findAll();
    }
}
