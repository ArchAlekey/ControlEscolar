package com.tramp.controlescolar.services;

import com.tramp.controlescolar.dto.PeriodoRequestDto;
import com.tramp.controlescolar.models.catalogos.Periodos;
import com.tramp.controlescolar.repository.PeriodosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PeriodosService {
    @Autowired
    private PeriodosRepository periodosRepository;

    public Periodos insertarPeriodo(PeriodoRequestDto dto) {
        Periodos nuevo = new Periodos();
        nuevo.setPeriodo(dto.getCperiodo());
        nuevo.setAnio(dto.getCanio());
        nuevo.setHabilitado(dto.getBhabilitado());
        nuevo.setFechaAlta(new Date());
        nuevo.setFechaBaja(null);
        return periodosRepository.save(nuevo);
    }

    public boolean cambiarEstadoPeriodo(Integer nidPeriodo, boolean nuevoEstado) {
        int afectados = periodosRepository.cambiarEstadoPeriodo(nidPeriodo, nuevoEstado);
        return afectados == 1;
    }

    public boolean actualizarPeriodo(Integer nidPeriodo, String cperiodo, String canio, boolean bhabilitado) {
        int afectados = periodosRepository.actualizarPeriodo(nidPeriodo, cperiodo, canio, bhabilitado);
        return afectados == 1;
    }
}
