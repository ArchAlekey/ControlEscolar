package com.tramp.controlescolar.controllers;

import com.tramp.controlescolar.services.ProfesoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

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

    @PostMapping("/insertarCalificacion")
    public ResponseEntity<?> insertarCalificacion(
            @RequestParam Integer nid_materia,
            @RequestParam Integer nid_usuario,
            @RequestParam Float ncalificacion
    ) {
        try {
            profesoresService.insertaCalificaciones(nid_materia, nid_usuario, ncalificacion);
            return ResponseEntity.ok("Calificación insertada correctamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al insertar calificación: " + e.getMessage());
        }
    }

    @GetMapping("/consultaAlumnosInscritos")
    public ResponseEntity<?> consultaAlumnosInscritos(
            @RequestParam Integer nid_grupo
    ){
        try{
            List<Map<String, Object>> alumnos = profesoresService.consultarAlumnosInscritos(nid_grupo);
            return ResponseEntity.ok(alumnos);
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al consultar horarios " + e.getMessage());

        }
    }
}
