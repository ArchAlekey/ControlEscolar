 package com.tramp.controlescolar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tramp.controlescolar.dto.UsuarioValidaDTO;
import com.tramp.controlescolar.models.tablas.Usuarios;

import org.springframework.transaction.annotation.Transactional;  // ✅ IMPORTACIÓN CORRECTA



@Repository
public interface UsuarioRepository extends JpaRepository<Usuarios, Integer>{
        
        @Transactional
        @Procedure(procedureName = "SPD_CONS_USUARIO")
        List<UsuarioValidaDTO> validarUsuario(
                @Param("StrUsuario") String usuario,
                @Param("StrContrasenia") String contrasenia
        );

        
        @Transactional
        @Procedure(procedureName = "SPD_CAMBIA_CONTRASENIA")
        void actualizaContrasenia(
                @Param("IntIdUsuario") Integer nid_usuario,
                @Param("StrContrasenia") String ccontrasenia
        );

}
