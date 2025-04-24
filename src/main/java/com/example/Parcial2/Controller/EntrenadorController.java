package com.example.Parcial2.Controller;

import com.example.Parcial2.Model.Entrenador;
import com.example.Parcial2.Service.EntrenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entrenadores")
public class EntrenadorController {

    @Autowired
    private EntrenadorService entrenadorService;

    @GetMapping
    public List<Entrenador> getAll() {
        return entrenadorService.getAllEntrenadores();
    }

    @GetMapping("/{id}")
    public Entrenador getById(@PathVariable int id) {
        return entrenadorService.getEntrenadorById(id);
    }

    @PostMapping
    public Entrenador save(@RequestBody Entrenador entrenador) {
        return entrenadorService.saveEntrenador(entrenador);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        entrenadorService.deleteEntrenador(id);
    }
}

