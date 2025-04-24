package com.example.Parcial2.Controller;


import com.example.Parcial2.Model.Partido;
import com.example.Parcial2.Service.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/partidos")
public class PartidoController {

    @Autowired
    private PartidoService partidoService;

    @GetMapping
    public List<Partido> getAll() {
        return partidoService.getAllPartidos();
    }

    @GetMapping("/{id}")
    public Partido getById(@PathVariable int id) {
        return partidoService.getPartidoById(id);
    }

    @PostMapping
    public Partido save(@RequestBody Partido partido) {
        return partidoService.savePartido(partido);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        partidoService.deletePartido(id);
    }

    // Consulta nativa 4
    @GetMapping("/resultados")
    public List<Object[]> getResultados() {
        return partidoService.getResultadosConNombres();
    }
}
