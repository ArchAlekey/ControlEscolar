 package com.tramp.controlescolar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tramp.controlescolar.models.tablas.Usuarios;

import org.springframework.transaction.annotation.Transactional;  // ✅ IMPORTACIÓN CORRECTA



@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuarios, Integer>{
        
        @Transactional
        @Procedure(procedureName = "SPD_CONS_USUARIO")
        List<Usuarios> validarUsuario(@Param("StrUsuario") String usuario, @Param("StrContrasenia") String contrasenia); 
}
