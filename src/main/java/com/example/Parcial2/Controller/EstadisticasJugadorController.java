package com.example.Parcial2.Controller;


import com.example.Parcial2.Model.EstadisticasJugador;
import com.example.Parcial2.Service.EstadisticasJugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estadisticas")
public class EstadisticasJugadorController {

    @Autowired
    private EstadisticasJugadorService estadisticasJugadorService;

    @GetMapping
    public List<EstadisticasJugador> getAll() {
        return estadisticasJugadorService.getAllEstadisticas();
    }

    @GetMapping("/{id}")
    public EstadisticasJugador getById(@PathVariable int id) {
        return estadisticasJugadorService.getEstadisticaById(id);
    }

    @PostMapping
    public EstadisticasJugador save(@RequestBody EstadisticasJugador estadistica) {
        return estadisticasJugadorService.saveEstadistica(estadistica);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        estadisticasJugadorService.deleteEstadistica(id);
    }

    // Consulta nativa 3
    @GetMapping("/goles-totales/{idEquipo}")
    public Integer getTotalGolesPorEquipo(@PathVariable int idEquipo) {
        return estadisticasJugadorService.totalGolesPorEquipo(idEquipo);
    }
}
