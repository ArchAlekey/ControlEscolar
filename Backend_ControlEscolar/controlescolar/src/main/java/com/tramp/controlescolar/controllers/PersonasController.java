package com.tramp.controlescolar.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.tramp.controlescolar.dto.PersonaUsuarioRequest;
import com.tramp.controlescolar.services.PersonasService;


@RestController
@CrossOrigin(origins = "*")
public class PersonasController {   

    @Autowired
    private PersonasService personasService;

    //Ingresa al procedimiento almacenado SPD_INSERTA_PERSONA_ADMIN
    @PostMapping("registrar/administrador")
    public ResponseEntity<String> crearAdministrador(@RequestBody PersonaUsuarioRequest request){
        try {
            personasService.insertarAdministrador(request);
            return ResponseEntity.ok("Admnistrador registrado correctamente");
        } catch (Exception e) {
            return  ResponseEntity.status(500).body("Error al registrar administrador: " + e.getMessage());

        }
    }

    //Ingresa al procedimiento almacenado SPD_INSERTA_PERSONA_ALUMNO
    @PostMapping("registrar/profesor")
    public ResponseEntity<String> crearProfesor(@RequestBody PersonaUsuarioRequest request){
        try {
            personasService.insertarProfesor(request);
            return ResponseEntity.ok("Profesor registrado correctamente");
        } catch (Exception e) {
            return  ResponseEntity.status(500).body("Error al registrar profesor: " + e.getMessage());

        }
    }

    @PostMapping("registrar/alumno")
    public ResponseEntity<String> crearAlumno(@RequestBody PersonaUsuarioRequest request){
        try {
            personasService.insertarAlumno(request);
            return ResponseEntity.ok("Alumno registrado correctamente");
        } catch (Exception e) {
            return  ResponseEntity.status(500).body("Error al registrar alumno: " + e.getMessage());

        }
    }

    @PostMapping("actualiza/persona")
    public ResponseEntity<String> actualizarPersona(@RequestBody PersonaUsuarioRequest request){
        try {
            personasService.actualizaPersona(request);
            return ResponseEntity.ok("Persona actualizada correctamente");

        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al actualizar persona: " + e.getMessage());
        }
    }

    @GetMapping("/consulta/datosPersonales")
    public ResponseEntity<?> obtenerDatosPersonales(@RequestParam("nid_persona") Integer nid_persona){
        try{
            PersonaUsuarioRequest datos = personasService.consultaDatosPersonales(nid_persona);

            if (datos == null) {
                return ResponseEntity.status(404).body(Map.of(
                    "success", false,
                    "message", "No se encontraron datos para el ID proporcionado"
                ));
            }
    
            return ResponseEntity.ok(Map.of(
                "success", true,
                "data", datos
            ));

        } catch(Exception e) {

            return ResponseEntity.status(500).body(Map.of(
                "success", false,
                "message", "Error interno del servidor" + e.getMessage()
            ));
        }
    }
    
}
