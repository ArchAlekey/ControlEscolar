package com.tramp.controlescolar.controllers;


import com.tramp.controlescolar.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import java.util.Map;

@RestController
@RequestMapping("/correo")
public class    EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("enviar")
    public ResponseEntity<Map<String, String>> enviar(
            @RequestParam String destinatario,
            @RequestParam String asunto,
            @RequestParam String contenido
    ) {
         try {
            // Se llama al servicio de correo para enviar el correo
            String resultado = emailService.enviarCorreo(destinatario, asunto, contenido);
            // Se retorna el resultado del envío
            return ResponseEntity.ok(Map.of("message", "Envío de correo exitoso"));
         } catch (Exception e) {
            // En caso de error, se captura la excepción y se retorna un mensaje de error
             return ResponseEntity.status(500).body(Map.of("error", "Error: " + e.getMessage()));
         }
    }
}
