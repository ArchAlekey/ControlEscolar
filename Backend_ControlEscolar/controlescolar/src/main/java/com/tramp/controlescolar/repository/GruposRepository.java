package com.tramp.controlescolar.repository;

import com.tramp.controlescolar.models.catalogos.Grupos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GruposRepository extends JpaRepository<Grupos, Integer> {

    List<Grupos> findByBhabilitado(boolean bhabilitado);
}
