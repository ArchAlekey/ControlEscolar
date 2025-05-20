package com.tramp.controlescolar.controllers;

import com.tramp.controlescolar.models.catalogos.Semestres;
import com.tramp.controlescolar.services.SemestresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/semestres")
public class SemestresController {
    @Autowired
    private SemestresService semestreService;

    @GetMapping("mostrar")
    public List<Semestres> mostrarSemestres() {
        return semestreService.mostrarSemestres();
    }
}
