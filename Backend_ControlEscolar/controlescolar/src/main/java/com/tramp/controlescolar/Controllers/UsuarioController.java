package com.tramp.controlescolar.Controllers;

/* import java.util.List; */
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tramp.controlescolar.Service.usuarioService;
import com.tramp.controlescolar.models.tablas.Usuarios;

import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/login")  // Cambiado a una ruta más descriptiva
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<?> validateUsuario(@RequestBody LoginRequest loginRequest) {
        Optional<Usuarios> usuario = usuarioService.validateUsuarios(loginRequest.getCusuario(), loginRequest.getCcontrasenia());
        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario.get());  // Devolver directamente el objeto Usuario
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }
    }
}
