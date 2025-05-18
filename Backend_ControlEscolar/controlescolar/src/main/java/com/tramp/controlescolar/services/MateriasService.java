package com.tramp.controlescolar.services;

import com.tramp.controlescolar.models.catalogos.Materias;
import com.tramp.controlescolar.repository.MateriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MateriasService {
    @Autowired
    private MateriasRepository materiasRepository;

    public List<Materias> mostrarMateriasPorCarreraYSemestre(Integer idCarrera, Integer idSemestre) {
        return materiasRepository.buscarPorCarreraYSemestre(idCarrera, idSemestre);
    }
}
