package com.tramp.controlescolar.repository;

import com.tramp.controlescolar.models.catalogos.Periodos;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodosRepository extends JpaRepository<Periodos, Integer> {

    @Modifying
    @Transactional
    @Query(
            value = "UPDATE cat_periodos SET bhabilitado = :nuevoEstado, dfecha_baja = CASE WHEN :nuevoEstado = 0 THEN CURRENT_DATE ELSE NULL END WHERE nid_periodo = :nidPeriodo",
            nativeQuery = true
    )
    int cambiarEstadoPeriodo(@Param("nidPeriodo") Integer nidPeriodo, @Param("nuevoEstado") boolean nuevoEstado);


    @Modifying
    @Transactional
    @Query(
            value = "UPDATE cat_periodos " +
                    "SET cperiodo = :cperiodo, " +
                    "canio = :canio, " +
                    "bhabilitado = :bhabilitado " +
                    "WHERE nid_periodo = :nidPeriodo",
            nativeQuery = true
    )
    int actualizarPeriodo(
            @Param("nidPeriodo") Integer nidPeriodo,
            @Param("cperiodo") String cperiodo,
            @Param("canio") String canio,
            @Param("bhabilitado") boolean bhabilitado
    );
    

}