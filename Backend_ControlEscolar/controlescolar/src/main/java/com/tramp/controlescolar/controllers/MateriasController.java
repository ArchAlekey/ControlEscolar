package com.tramp.controlescolar.controllers;

import com.tramp.controlescolar.models.catalogos.Materias;
import com.tramp.controlescolar.services.MateriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/materias")
public class MateriasController {
    @Autowired
    private MateriasService materiasService;

    @GetMapping("mostrarMaterias")
    public List<Materias> mostrarMateriasPorCarreraYSemestre(
            @RequestParam Integer idCarrera,
            @RequestParam Integer idSemestre) {
        return materiasService.mostrarMateriasPorCarreraYSemestre(idCarrera, idSemestre);
    }
}
