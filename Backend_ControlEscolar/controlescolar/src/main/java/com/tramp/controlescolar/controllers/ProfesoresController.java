package com.tramp.controlescolar.controllers;

import com.tramp.controlescolar.services.ProfesoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/profesores")
public class ProfesoresController {
    @Autowired
    private ProfesoresService profesoresService;

    @GetMapping("/consultarGruposAsignados")
    public ResponseEntity<?> consultarGruposAsignados(
            @RequestParam Integer nid_academico_profesor
    ) {
        try {
            List<Map<String, Object>> grupos = profesoresService.consultaGruposAsignados((nid_academico_profesor));
            return ResponseEntity.ok(grupos);
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al consultar grupos asignados: " + e.getMessage());
        }

    }
}
