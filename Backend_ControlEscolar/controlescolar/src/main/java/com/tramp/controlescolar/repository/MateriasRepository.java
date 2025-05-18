package com.tramp.controlescolar.repository;

import com.tramp.controlescolar.models.catalogos.Materias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MateriasRepository extends JpaRepository<Materias, Integer> {

    @Query(
            value = "SELECT * FROM cat_materias WHERE nid_carrera = :nidCarrera AND nid_semestre = :nidSemestre",
            nativeQuery = true
    )
    List<Materias> buscarPorCarreraYSemestre(
            @Param("nidCarrera") Integer nidCarrera,
            @Param("nidSemestre") Integer nidSemestre
    );
}
