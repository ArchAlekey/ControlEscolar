package com.tramp.controlescolar.services;

import com.tramp.controlescolar.models.catalogos.Semestres;
import com.tramp.controlescolar.repository.SemestresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SemestresService {
    @Autowired
    private SemestresRepository semestresRepository;

    public List<Semestres> mostrarSemestres() {
        return semestresRepository.findAll();
    }
}
