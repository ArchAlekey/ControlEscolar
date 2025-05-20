package com.tramp.controlescolar.controllers;

import com.tramp.controlescolar.dto.PeriodoRequestDto;
import com.tramp.controlescolar.models.catalogos.Periodos;
import com.tramp.controlescolar.repository.PeriodosRepository;
import com.tramp.controlescolar.services.PeriodosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("periodos")
public class PeriodosController {

    @Autowired
    private PeriodosRepository periodosRepository;

    @Autowired
    private PeriodosService periodosService;

    @PostMapping("inserta")
    public ResponseEntity<?> insertarPeriodo(@RequestBody PeriodoRequestDto body) {
        Periodos nuevo = periodosService.insertarPeriodo(body);
        return ResponseEntity.ok(Map.of(
                "status", "success",
                "message", "Periodo insertado correctamente",
                "nidPeriodo", nuevo.getIdPeriodo()
        ));
    }
    
    @GetMapping("mostrar")
    public List<Periodos> mostrarPeriodos(){
        List<Periodos> listaPeriodos = periodosRepository.findAll();
        return listaPeriodos;
    }

    @PutMapping("/cambiarEstado/{nidPeriodo}")
    public ResponseEntity<?> cambiarEstado(@PathVariable Integer nidPeriodo, @RequestParam boolean habilitar) {
        boolean ok = periodosService.cambiarEstadoPeriodo(nidPeriodo, habilitar);
        if (ok) {
            return ResponseEntity.ok(Map.of(
                    "status", "success",
                    "message", habilitar ? "Periodo habilitado correctamente" : "Periodo inhabilitado correctamente",
                    "nidPeriodo", nidPeriodo
            ));
        } else {
            return ResponseEntity.status(404).body(Map.of(
                    "status", "error",
                    "message", "No se pudo cambiar el estado del periodo. Verifica el ID.",
                    "nidPeriodo", nidPeriodo
            ));
        }
    }

    @PutMapping("/actualiza/{nidPeriodo}")
    public ResponseEntity<?> actualizarPeriodo(
            @PathVariable Integer nidPeriodo,
            @RequestBody Map<String, Object> body
    ) {
        String cperiodo = (String) body.get("cperiodo");
        String canio = (String) body.get("canio");
        boolean bhabilitado = (boolean) body.get("bhabilitado");

        boolean ok = periodosService.actualizarPeriodo(nidPeriodo, cperiodo, canio, bhabilitado);
        if (ok) {
            return ResponseEntity.ok(Map.of(
                    "status", "success",
                    "message", "Periodo actualizado correctamente",
                    "nidPeriodo", nidPeriodo
            ));
        } else {
            return ResponseEntity.status(404).body(Map.of(
                    "status", "error",
                    "message", "No se pudo actualizar el periodo. Verifica el ID.",
                    "nidPeriodo", nidPeriodo
            ));
        }
    }


}