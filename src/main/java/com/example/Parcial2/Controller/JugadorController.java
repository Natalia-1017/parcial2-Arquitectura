package com.example.Parcial2.Controller;


import com.example.Parcial2.Model.Jugador;
import com.example.Parcial2.Service.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jugadores")
public class JugadorController {

    @Autowired
    private JugadorService jugadorService;

    @GetMapping
    public List<Jugador> getAll() {
        return jugadorService.getAllJugadores();
    }

    @GetMapping("/{id}")
    public Jugador getById(@PathVariable int id) {
        return jugadorService.getJugadorById(id);
    }

    @PostMapping
    public Jugador save(@RequestBody Jugador jugador) {
        return jugadorService.saveJugador(jugador);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        jugadorService.deleteJugador(id);
    }

    // Endpoint para obtener jugadores por equipo específico
    @GetMapping("/equipo/{idEquipo}")
    public ResponseEntity<List<Object[]>> getJugadoresByEquipoId(@PathVariable int idEquipo) {
        List<Object[]> jugadores = jugadorService.getJugadoresByEquipoId(idEquipo);
        return ResponseEntity.ok(jugadores);
    }

    // Endpoint para obtener jugadores que han marcado más de X goles
    @GetMapping("/goles/{goles}")
    public ResponseEntity<List<Object[]>> getJugadoresConMasDeXGoles(@PathVariable int goles) {
        List<Object[]> jugadores = jugadorService.getJugadoresConMasDeXGoles(goles);
        return ResponseEntity.ok(jugadores);
    }
}
