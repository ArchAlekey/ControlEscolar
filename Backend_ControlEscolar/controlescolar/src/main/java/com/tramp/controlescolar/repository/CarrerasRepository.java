package com.tramp.controlescolar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tramp.controlescolar.models.catalogos.Carreras;


public interface CarrerasRepository extends JpaRepository<Carreras, Integer>{
    
}
