package com.tramp.controlescolar.repository;

import com.tramp.controlescolar.models.tablas.Personas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface AlumnosRepository extends JpaRepository<Personas, Integer>{


    //Procedimiento SPD_INSERTA_INSCRIPCION
    @Procedure(procedureName = "SPD_INSERTA_INSCRIPCION")
    void insertarInscripcion(
            @Param("IntIdUSuario") Integer nid_usuario,
            @Param("IntIdGrupo") Integer nid_grupo
        );

    //Procedimiento SPD_CONSULTA_CALIFICACIONES
    @Procedure(procedureName = "SPD_CONSULTA_CALIFICACIONES")
    List<Object[]> consultarCalificaciones(
            @Param("IntIdUsuario") Integer nid_usuario
        );
     
     //Procedimiento SPD_INSERTA_INSCRIPCION 
     @Procedure(procedureName = "SPD_CONSULTA_INSCRIPCION")
     List<Object[]> consultarInscripcion(
        @Param("IntIdUsuario") Integer nid_usuario
        );
}
