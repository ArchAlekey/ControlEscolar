package com.tramp.controlescolar.Controllers;

import java.util.List;

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
@RequestMapping("/Usuarios")
public class UsuarioController {
    @Autowired
    private usuarioService _usuarioService;

    @PostMapping("/valida")
    public ResponseEntity<?> validateUsuario(@RequestParam String cusuario, @RequestParam String ccontrasenia){

        List<Usuarios> usuario = _usuarioService.validateUsuarios(cusuario, ccontrasenia);

        if(!usuario.isEmpty()){
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales Invalidas");
        }
    }
    
}
