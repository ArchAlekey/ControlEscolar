package com.tramp.controlescolar.repository;

import com.tramp.controlescolar.models.catalogos.Horarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HorariosRepository extends JpaRepository<Horarios, Integer> {
    @Procedure(procedureName = "SPD_CONSULTA_HORARIO")
    List<Object[]> consultaHorario(@Param("IntCarrera") Integer carrera, @Param("IntGrupo") Integer grupo);
}
