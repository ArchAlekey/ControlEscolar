package com.tramp.controlescolar.controllers;

import com.tramp.controlescolar.services.AlumnosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/alumnos")
public class AlumnosController {
    @Autowired
    private AlumnosService alumnosService;

    @PostMapping("/insertaInscripcion")
    public ResponseEntity<?> insertarInscripcion(@RequestBody Map<String, Object> body){

        Integer nid_usuario = Integer.valueOf(body.get("nid_usuario").toString());
        Integer nid_grupo = Integer.valueOf((body.get("nid_grupo").toString()));
        try{
            alumnosService.insertaInscripcion(nid_usuario, nid_grupo);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Inscripción Exitosa");
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al insertar inscripción: " + e.getMessage());
        }

    }

    @GetMapping("/consultaInscripcion")
    public ResponseEntity<?> consultaInscripcion(@RequestParam Integer nid_usuario){
        try{
            List<Map<String, Object>> inscripcion = alumnosService.consultaInscripcion(nid_usuario);
            return ResponseEntity.ok(inscripcion);
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al consultar inscripción" + e.getMessage());

        }
    }
    @GetMapping("/academicosAlumnos")
    public ResponseEntity<?> obtenerAcademicosAlumnosConPersonas() {
        try {
            List<Map<String, Object>> datos = alumnosService.obtenerAcademicosAlumnosConPersonas();
            return ResponseEntity.ok(datos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al obtener datos: " + e.getMessage());
        }
    }

    @PutMapping("/cambiarEstado/{id}")
    public ResponseEntity<?> cambiarEstadoHabilitado(
            @PathVariable("id") Integer idAlumno,
            @RequestParam("habilitado") boolean habilitado) {
        try {
            alumnosService.cambiarEstadoHabilitado(idAlumno, habilitado);
            // Retorna en formato JSON
            return ResponseEntity.ok(Map.of("mensaje", "Estado actualizado correctamente."));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al actualizar el estado: " + e.getMessage());
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<?> buscarAlumnos(@RequestParam("texto") String textoBusqueda) {
        try {
            List<Map<String, Object>> alumnos = alumnosService.buscarAlumnos(textoBusqueda);
            return ResponseEntity.ok(alumnos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al buscar alumnos: " + e.getMessage());
        }
    }

    @GetMapping("/consultaHistorial")
    public ResponseEntity<?> consultarHistorial(@RequestParam Integer nid_usuario) {
        try{
            List<Map<String, Object>> historial = alumnosService.consultarHistorial(nid_usuario);
            return ResponseEntity.ok(historial);
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al consultar inscripción" + e.getMessage());

        }
    }
    

}
