package com.tramp.controlescolar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.*;
import org.springframework.stereotype.Repository;
import com.tramp.controlescolar.models.tablas.HorarioMaterias;

@Repository
public interface HorarioMateriasRepository extends JpaRepository<HorarioMaterias, Integer> {
    //Procedimiento para consultar toda la tabla de horarios
    @Query(value = "CALL SPD_CONSULTA_HORARIOS(:IntCarrera, :IntGrupo)", nativeQuery = true)
    List<Object[]> ConsultaHorarios(@Param("IntCarrera") Integer IntCarrera, @Param("IntGrupo") Integer IntGrupo);

    //Consulta horarios disponibles para la inscripción
    @Query(value = "Select distinct thm.nid_grupo, cg.cgrupo From tbl_horario_materias as thm inner join cat_grupos as cg on thm.nid_grupo = cg.nid_grupo", nativeQuery = true)
    List<Object[]> ConsultaHorariosInsc();

    @Procedure(procedureName = "SPD_ASIGNAR_PROFESOR_MATERIA")
    Integer asignarProfesorMateria(
            @Param("p_nid_carrera") Integer nidCarrera,
            @Param("p_nid_periodo") Integer nidPeriodo,
            @Param("p_nid_semestre") Integer nidSemestre,
            @Param("p_nid_grupo") Integer nidGrupo,
            @Param("p_nid_academico_profesor") Integer nidAcademicoProfesor,
            @Param("p_nid_horario") Integer nidHorario,
            @Param("p_nid_materia") Integer nidMateria
    );
}
