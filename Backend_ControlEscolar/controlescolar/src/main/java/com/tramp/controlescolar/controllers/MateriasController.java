package com.tramp.controlescolar.controllers;

import com.tramp.controlescolar.models.catalogos.Materias;
import com.tramp.controlescolar.services.MateriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
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
