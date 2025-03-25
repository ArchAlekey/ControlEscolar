package com.tramp.controlescolar.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import com.tramp.controlescolar.models.tablas.Usuarios;



public interface usuarioRepositorio extends JpaRepository<Usuarios, Long> {

    @Procedure(name = "SPD_CONS_USUARIO")
    List<Usuarios> validateUsuarios(@Param("StrUsuario") String cusuario, @Param("StrContrasenia") String ccontrasenia);
}