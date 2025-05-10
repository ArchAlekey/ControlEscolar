package com.tramp.controlescolar.controllers;

import com.tramp.controlescolar.services.AlumnosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/consultaCalificaciones")
    public ResponseEntity<?> consultarCalificaciones(@RequestParam Integer nid_usuario){
        try{
            List<Map<String, Object>> calificaciones = alumnosService.consultarCalificaciones(nid_usuario);
            return ResponseEntity.ok(calificaciones);
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al consultar calificaciones" + e.getMessage());

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

}
