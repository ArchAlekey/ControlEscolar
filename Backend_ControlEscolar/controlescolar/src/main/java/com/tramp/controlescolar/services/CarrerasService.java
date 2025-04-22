package com.tramp.controlescolar.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tramp.controlescolar.models.catalogos.Carreras;
import com.tramp.controlescolar.repository.CarrerasRepository;

@Service
public class CarrerasService {
    @Autowired
    private CarrerasRepository carrerasRepository;

    public Carreras guardarCarrera(Carreras carreras) {
        return carrerasRepository.save(carreras);
    }
    public Carreras actualizCarreras(Carreras carreras) {
        if (!carrerasRepository.existsById(carreras.getIdCarrera())) {
            throw new RuntimeException("Carrera no encontrada con id: " + carreras.getIdCarrera());
        }
        return carrerasRepository.save(carreras);
    }

    public void eliminarCarrera(int id) {
        if (!carrerasRepository.existsById(id)) {
            throw new RuntimeException("Carrera no encontrada con id: " + id);
        }
        carrerasRepository.deleteById(id);
    }
}
