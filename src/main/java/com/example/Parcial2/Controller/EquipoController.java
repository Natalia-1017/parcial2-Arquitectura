package com.example.Parcial2.Controller;

import com.example.Parcial2.Model.Equipo;
import com.example.Parcial2.Service.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/equipos")
public class EquipoController {

    @Autowired
    private EquipoService equipoService;

    //Obtener todos los equipos (sin valores nulos)
    @GetMapping
    public List<Object> getAll() {
        return equipoService.getAllEquipos().stream().map(equipo -> {
            return new Object() {
                public final Integer id_equipo = equipo.getId_equipo();
                public final String nombre = equipo.getNombre();
                public final String ciudad = equipo.getCiudad();
                public final String fundacion = equipo.getFundacion().toString();
            };
        }).collect(Collectors.toList());
    }

    // GET: Obtener un equipo por ID (sin valores nulos)
    @GetMapping("/{id}")
    public Object getById(@PathVariable int id) {
        Equipo equipo = equipoService.getEquipoById(id);
        if (equipo != null) {
            return new Object() {
                public final Integer id_equipo = equipo.getId_equipo();
                public final String nombre = equipo.getNombre();
                public final String ciudad = equipo.getCiudad();
                public final String fundacion = equipo.getFundacion().toString();
            };
        }
        return null;
    }

    // POST: Guardar un nuevo equipo
    @PostMapping
    public Equipo save(@RequestBody Equipo equipo) {
        return equipoService.saveEquipo(equipo);
    }

    // PUT: Actualizar un equipo existente
    @PutMapping("/{id}")
    public Equipo update(@PathVariable int id, @RequestBody Equipo equipo) {
        Equipo existingEquipo = equipoService.getEquipoById(id);
        if (existingEquipo != null) {
            existingEquipo.setNombre(equipo.getNombre());
            existingEquipo.setCiudad(equipo.getCiudad());
            existingEquipo.setFundacion(equipo.getFundacion());
            return equipoService.saveEquipo(existingEquipo);
        }
        return null;
    }

    // DELETE: Eliminar un equipo por ID
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        equipoService.deleteEquipo(id);
    }
}