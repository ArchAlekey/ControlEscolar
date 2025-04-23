package com.tramp.controlescolar.repository;

import com.tramp.controlescolar.models.tablas.AcademicosProfesores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProfesoresRepository extends JpaRepository<AcademicosProfesores, Integer> {
    //Procedimiento SPD_CONSULTA_GRUPOS_ASIGNADOS
    @Procedure(procedureName = "SPD_CONSULTA_GRUPOS_ASIGNADOS")
    List<Object[]> consultaGruposAsignados(
            @Param("IntIdAcademicoProfesor") Integer nid_academico_profesor
    );

    //Procedimiento SPD_INSERTA_CALIFICACION

}
