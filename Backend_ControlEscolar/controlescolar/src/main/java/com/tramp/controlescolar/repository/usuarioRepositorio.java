package com.tramp.controlescolar.repository;

/* import java.util.List; */
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tramp.controlescolar.models.tablas.Usuarios;

@Repository
public interface usuarioRepositorio extends JpaRepository<Usuarios, Integer> {

    @Procedure(name = "SPD_CONS_USUARIO")
    Optional<Usuarios> validateUsuarios(@Param("StrUsuario") String cusuario, @Param("StrContrasenia") String ccontrasenia);
}