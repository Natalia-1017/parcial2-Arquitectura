package com.example.Parcial2.Repository;

import com.example.Parcial2.Model.EstadisticasJugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EstadisticasJugadorRepository extends JpaRepository<EstadisticasJugador, Integer> {

    // Consulta 3: Total de goles de un equipo
    @Query(value = "SELECT SUM(ej.goles) FROM estadisticas_jugador ej " +
            "JOIN jugador j ON ej.id_jugador = j.id_jugador " +
            "WHERE j.id_equipo = ?1", nativeQuery = true)
    Integer totalGolesPorEquipo(int idEquipo);
}

