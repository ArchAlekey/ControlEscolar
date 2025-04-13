package com.tramp.controlescolar.services;

import com.tramp.controlescolar.repository.HorariosRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HorariosService {
    @Autowired
    private HorariosRepository horariosRepository;

    @Transactional
    public List<Map<String, Object>> obtenerHorario(Integer carrera, Integer grupo) {
        List<Object[]> resultados = horariosRepository.consultaHorario(carrera, grupo);
        List<Map<String, Object>> horarios = new ArrayList<>();

        //Iteramos sobre los resultados devueltos en el procedimiento
        for(Object[] fila: resultados) {
            //Asignamos cada columna del resultado a su respectivo campo en el mapa
            Map<String, Object> horario = new HashMap<>();
            horario.put("nid_horario_materia", fila[0]);
            horario.put("nombre_materia", fila[1]);
            horario.put("clave_materia", fila[2]);
            horario.put("carrera", fila[3]);
            horario.put("periodo", fila[4]);
            horario.put("semestre", fila[5]);
            horario.put("grupo", fila[6]);
            horario.put("profesor", fila[7]);
            horario.put("numero_cuenta", fila[8]);
            horario.put("correo_institucional", fila[9]);
            horario.put("horario", fila[10]);

            //Agregamos el objeto horario a la lista de resultados
            horarios.add(horario);
        }
        return horarios;
    }

}
