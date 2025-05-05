package com.tramp.controlescolar.controllers;


import com.tramp.controlescolar.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/correo")
public class    EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("enviar")
    public String enviar(
            @RequestParam String destinatario,
            @RequestParam String asunto,
            @RequestParam String contenido
    ) {
         try {
            // Se llama al servicio de correo para enviar el correo
             return emailService.enviarCorreo(destinatario,asunto, contenido);
         } catch (Exception e) {
            // En caso de error, se captura la excepción y se retorna un mensaje de error
             return "Error: " + e.getMessage();
         }
    }
}
