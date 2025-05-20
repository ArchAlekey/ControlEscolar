package com.tramp.controlescolar.repository;

import com.tramp.controlescolar.models.catalogos.Horarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorariosRepository extends JpaRepository<Horarios, Integer> {

}
