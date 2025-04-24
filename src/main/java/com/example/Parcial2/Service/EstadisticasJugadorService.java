package com.example.Parcial2.Service;

import com.example.Parcial2.Model.EstadisticasJugador;
import com.example.Parcial2.Repository.EstadisticasJugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadisticasJugadorService {

    @Autowired
    private EstadisticasJugadorRepository estadisticasJugadorRepository;

    public List<EstadisticasJugador> getAllEstadisticas() {
        return estadisticasJugadorRepository.findAll();
    }

    public EstadisticasJugador getEstadisticaById(int id) {
        return estadisticasJugadorRepository.findById(id).orElse(null);
    }

    public EstadisticasJugador saveEstadistica(EstadisticasJugador estadistica) {
        return estadisticasJugadorRepository.save(estadistica);
    }

    public void deleteEstadistica(int id) {
        estadisticasJugadorRepository.deleteById(id);
    }

    public Integer totalGolesPorEquipo(int idEquipo) {
        return estadisticasJugadorRepository.totalGolesPorEquipo(idEquipo);
    }
}
