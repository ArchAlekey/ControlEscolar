package com.tramp.controlescolar.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tramp.controlescolar.dto.HorarioMateriasDTO;
import com.tramp.controlescolar.dto.HorariosMateriasInscDTO;
import com.tramp.controlescolar.dto.InscripcionHorarioMateriaDTO;
import com.tramp.controlescolar.services.HorarioMateriasService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/horarios")
public class HorarioMateriasController {

    @Autowired
    private HorarioMateriasService horarioMateriasService;

    @GetMapping("/consulta")
    public ResponseEntity<Map<String, Object>> ConsultarHorarios(@RequestParam Integer IntCarrera, @RequestParam Integer IntGrupo){
        List<HorarioMateriasDTO> resultados = horarioMateriasService.ConsultaHorarios(IntCarrera, IntGrupo);

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Consulta exitosa");
        response.put("data", resultados);

        return ResponseEntity.ok(response);
    };

    @GetMapping("/inscripcion")
    public ResponseEntity<Map<String, Object>> ConsultaHorariosInsc(){
        List<HorariosMateriasInscDTO> horariosResultados = horarioMateriasService.ConsultaHorariosInsc();

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Consulta exitosa");
        response.put("data", horariosResultados);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/asignar")
    public ResponseEntity<?> asignar(@RequestBody InscripcionHorarioMateriaDTO dto) {
        try {
            horarioMateriasService.asignarProfesorMateria(dto);
            return ResponseEntity.ok("Asignación realizada correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al asignar profesor a materia: " + e.getMessage());
        }
    }
}
