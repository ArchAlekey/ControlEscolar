package com.tramp.controlescolar.controllers;

import com.tramp.controlescolar.models.catalogos.Grupos;
import com.tramp.controlescolar.services.GruposService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/grupos")
public class GruposController {

    @Autowired
    private GruposService gruposService;

    // Endpoint para mostrar TODOS los grupos
    @GetMapping("/mostrar")
    public List<Grupos> mostrarGrupos() {
        return gruposService.mostrarGrupos();
    }

    // Endpoint para mostrar solo los habilitados o inhabilitados según filtro
    @GetMapping("/mostrarEstado")
    public List<Grupos> mostrarGruposPorFiltro(@RequestParam boolean habilitado) {
        return gruposService.mostrarGruposPorEstado(habilitado);
    }
}
