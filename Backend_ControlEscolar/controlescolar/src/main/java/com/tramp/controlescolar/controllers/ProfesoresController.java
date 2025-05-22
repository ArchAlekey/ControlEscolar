package com.tramp.controlescolar.controllers;

import com.tramp.controlescolar.services.ProfesoresService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/profesores")
public class ProfesoresController {
    @Autowired
    private ProfesoresService profesoresService;

    @GetMapping("/consultarGruposAsignados")
    public ResponseEntity<?> consultarGruposAsignados(
            @RequestParam Integer nid_persona
    ) {
        try {
            List<Map<String, Object>> grupos = profesoresService.consultaGruposAsignados((nid_persona));
            return ResponseEntity.ok(grupos);
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al consultar grupos asignados: " + e.getMessage());
        }

    }

    @PostMapping("/insertarCalificacion")
    public ResponseEntity<?> insertarCalificacion(@RequestBody Map<String, Object> body) {
        Integer nid_horario_materia = Integer.valueOf(body.get("nid_horario_materia").toString());
        Integer nid_usuario = Integer.valueOf(body.get("nid_usuario").toString());
        Float ncalificacion = Float.valueOf(body.get("ncalificacion").toString());
        try {
            profesoresService.insertaCalificaciones(nid_horario_materia, nid_usuario, ncalificacion);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Asignación de calificaión exitosa");
            return ResponseEntity.ok(response);

        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al insertar calificación: " + e.getMessage());
        }
    }

    @PostMapping("/eliminarCalificacion")
    public ResponseEntity<?> eliminarCalificaion(@RequestBody Map<String, Object> body) {
        Integer nid_horario_materia = Integer.valueOf(body.get("nid_horario_materia").toString());
        Integer nid_usuario = Integer.valueOf(body.get("nid_usuario").toString());

        try {
            profesoresService.eliminaCalificacion(nid_horario_materia, nid_usuario);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Eliminación de calificaión exitosa");
            return ResponseEntity.ok(response);

        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al insertar calificación: " + e.getMessage());
        }
    }

    @GetMapping("/consultaAlumnosInscritos")
    public ResponseEntity<?> consultaAlumnosInscritos(
            @RequestParam Integer nid_grupo,
            @RequestParam Integer nid_materia
    ){
        try{
            List<Map<String, Object>> alumnos = profesoresService.consultarAlumnosInscritos(nid_grupo, nid_materia);
            return ResponseEntity.ok(alumnos);
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al consultar horarios " + e.getMessage());

        }
    }

    @GetMapping("/academicosProfesores")
    public ResponseEntity<?> obtenerAcademicosProfesoresConPersonas() {
        try {
            List<Map<String, Object>> datos = profesoresService.obtenerAcademicosProfesoresConPersonas();
            return ResponseEntity.ok(datos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al obtener datos: " + e.getMessage());
        }
    }

    @PutMapping("/cambiarEstado/{id}")
    public ResponseEntity<?> cambiarEstadoHabilitado(
            @PathVariable("id") Integer idProfesor,
            @RequestParam("habilitado") boolean habilitado) {
        try {
            profesoresService.cambiarEstadoHabilitado(idProfesor, habilitado);
            // Retorna en formato JSON
            return ResponseEntity.ok(Map.of("mensaje", "Estado actualizado correctamente."));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al actualizar el estado: " + e.getMessage());
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<?> buscarProfesores(@RequestParam("texto") String textoBusqueda) {
        try {
            List<Map<String, Object>> profesores = profesoresService.buscarProfesores(textoBusqueda);
            return ResponseEntity.ok(profesores);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al buscar profesores: " + e.getMessage());
        }
    }
}
