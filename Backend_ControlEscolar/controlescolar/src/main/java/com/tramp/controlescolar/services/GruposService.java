package com.tramp.controlescolar.services;


import com.tramp.controlescolar.models.catalogos.Grupos;
import com.tramp.controlescolar.repository.GruposRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GruposService {
    @Autowired
    private GruposRepository gruposRepository;

    public List<Grupos> mostrarGrupos() {
        return gruposRepository.findAll();
    }

    public List<Grupos> mostrarGruposPorEstado(boolean habilitado) {
        return gruposRepository.findByBhabilitado(habilitado);
    }

}
