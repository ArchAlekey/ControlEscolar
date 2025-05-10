package com.tramp.controlescolar.services;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import java.util.*;

import com.tramp.controlescolar.dto.HorarioMateriasDTO;
import com.tramp.controlescolar.dto.HorariosMateriasInscDTO;
import com.tramp.controlescolar.repository.HorarioMateriasRepository;

@Service
public class HorarioMateriasService {
    
    @Autowired
    private HorarioMateriasRepository _horarioMaterias;

    public List<HorarioMateriasDTO> ConsultaHorarios(Integer IntCarrera, Integer IntGrupo){
        List<Object[]> ListaResultado = _horarioMaterias.ConsultaHorarios(IntCarrera, IntGrupo);
        List<HorarioMateriasDTO> lista = new ArrayList<>();

        for(Object[] fila : ListaResultado){

            Integer nid_horario_materia = (Integer) fila[0];
            String cnombre_materia = (String) fila[1];
            String cclave_materia = (String) fila[2];
            String ccarrera = (String) fila[3];
            String cperiodo = (String) fila[4];
            Integer nsemestre = (Integer) fila[5];
            String cgrupo = (String) fila[6];
            String profesor = (String) fila[7];
            String cnumero_cuenta = (String) fila[8];
            String ccorreo_institucional = (String) fila[9];
            String chorario = (String) fila[10];
            lista.add(new HorarioMateriasDTO(
                nid_horario_materia,
                cnombre_materia,
                cclave_materia,
                ccarrera,
                cperiodo,
                nsemestre,
                cgrupo,
                profesor,
                cnumero_cuenta,
                ccorreo_institucional,
                chorario
            ));
        }
        return lista;
    };

    public List<HorariosMateriasInscDTO> ConsultaHorariosInsc(){
        List<Object[]> ListaInsc = _horarioMaterias.ConsultaHorariosInsc();
        List<HorariosMateriasInscDTO> Lista = new ArrayList<>();

        for(Object[] fila : ListaInsc){
            Integer nid_grupo = (Integer) fila[0];
            String cgrupo = (String) fila[1];

            Lista.add(new HorariosMateriasInscDTO(nid_grupo, cgrupo));
        }
        return Lista;
    }
}
