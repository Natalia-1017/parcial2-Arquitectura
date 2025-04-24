package com.example.Parcial2.Service;


import com.example.Parcial2.Model.Jugador;
import com.example.Parcial2.Repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JugadorService {

    @Autowired
    private JugadorRepository jugadorRepository;

    public List<Jugador> getAllJugadores() {
        return jugadorRepository.findAll();
    }

    public Jugador getJugadorById(int id) {
        return jugadorRepository.findById(id).orElse(null);
    }

    public Jugador saveJugador(Jugador jugador) {
        return jugadorRepository.save(jugador);
    }

    public void deleteJugador(int id) {
        jugadorRepository.deleteById(id);
    }

        // Obtener jugadores por equipo específico
        public List<Object[]> getJugadoresByEquipoId(int idEquipo) {
            return jugadorRepository.findJugadoresByEquipoId(idEquipo);
        }

        // Obtener jugadores que han marcado más de X goles
        public List<Object[]> getJugadoresConMasDeXGoles(int goles) {
            return jugadorRepository.findJugadoresConMasDeXGoles(goles);
        }
    }

