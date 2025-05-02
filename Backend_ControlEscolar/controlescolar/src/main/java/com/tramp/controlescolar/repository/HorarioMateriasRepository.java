package com.tramp.controlescolar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.*;
import org.springframework.stereotype.Repository;
import com.tramp.controlescolar.models.tablas.HorarioMaterias;

@Repository
public interface HorarioMateriasRepository extends JpaRepository<HorarioMaterias, Integer> {
    @Query(value = "CALL SPD_CONSULTA_HORARIOS(:IntCarrera, :IntGrupo)", nativeQuery = true)
    List<Object[]> ConsultaHorarios(@Param("IntCarrera") Integer IntCarrera, @Param("IntGrupo") Integer IntGrupo);
}
