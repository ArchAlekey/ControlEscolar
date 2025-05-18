package com.tramp.controlescolar.controllers;

import com.tramp.controlescolar.models.catalogos.Horarios;
import com.tramp.controlescolar.services.HorariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/horarios")
public class HorariosController {
    @Autowired
    private HorariosService horariosService;

    @GetMapping("mostrarHorarios")
    public List<Horarios> mostrarHorarios() {
        return horariosService.mostrarHorarios();
    }
}
