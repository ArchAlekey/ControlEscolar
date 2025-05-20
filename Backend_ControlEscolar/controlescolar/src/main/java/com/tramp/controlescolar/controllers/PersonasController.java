package com.tramp.controlescolar.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.tramp.controlescolar.dto.PersonaUsuarioRequest;
import com.tramp.controlescolar.services.PersonasService;
import org.springframework.http.HttpStatus;


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
    public ResponseEntity<Map<String, Object>> crearProfesor(@RequestBody PersonaUsuarioRequest request){
        Map<String, Object> respuesta = new HashMap<>();
        try {
            personasService.insertarProfesor(request);
            respuesta.put("mensaje", "Profesor registrado correctamente");
            // Retorna una respuesta exitosa con el mensaje
            return ResponseEntity.ok(respuesta);
        } catch (Exception e) {
            respuesta.put("error", "Error al registrar profesor: " + e.getMessage());
            return  ResponseEntity.status(500).body(respuesta);

        }
    }

    @PostMapping("registrar/alumno")
    public ResponseEntity<Map<String, Object>> crearAlumno(@RequestBody PersonaUsuarioRequest request){
        // Instanciar el mapa de respuesta
        Map<String, Object> respuesta =  new HashMap<>();        
        try {
            personasService.insertarAlumno(request);
            respuesta.put("mensaje", "Registrado correctamente");
            return ResponseEntity.ok(respuesta);
        } catch (Exception e) {
            respuesta.put("error", "Error al registrar alumno: " + e.getMessage());
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(respuesta);
        }
    }

    @PostMapping("actualiza/persona")
    public ResponseEntity<Map<String, String>> actualizarPersona(@RequestBody PersonaUsuarioRequest request){
        try {
            personasService.actualizaPersona(request);
            return ResponseEntity.ok(Map.of("mensaje", "Persona actualizada correctamente"));

        } catch (Exception e) {
            return ResponseEntity.status(500).body(Map.of("error", "Error al actualizar persona: " + e.getMessage()));
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
