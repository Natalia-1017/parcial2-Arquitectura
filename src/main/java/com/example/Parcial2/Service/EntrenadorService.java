package com.example.Parcial2.Service;

import com.example.Parcial2.Model.Entrenador;
import com.example.Parcial2.Repository.EntrenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntrenadorService {

    @Autowired
    private EntrenadorRepository entrenadorRepository;

    public List<Entrenador> getAllEntrenadores() {
        return entrenadorRepository.findAll();
    }

    public Entrenador getEntrenadorById(int id) {
        return entrenadorRepository.findById(id).orElse(null);
    }

    public Entrenador saveEntrenador(Entrenador entrenador) {
        return entrenadorRepository.save(entrenador);
    }

    public void deleteEntrenador(int id) {
        entrenadorRepository.deleteById(id);
    }
}


