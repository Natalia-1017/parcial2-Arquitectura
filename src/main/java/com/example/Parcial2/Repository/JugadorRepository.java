package com.example.Parcial2.Repository;


import com.example.Parcial2.Model.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Integer> {

    // Consulta 1: Obtener todos los jugadores de un equipo específico
    @Query(value = "SELECT j.id_jugador, j.nombre, j.posicion, j.fecha_nac, j.id_equipo " +
            "FROM jugador j " +
            "WHERE j.id_equipo = ?1", nativeQuery = true)
    List<Object[]> findJugadoresByEquipoId(int idEquipo);

    // Consulta 2: Obtener los jugadores que han marcado más de X goles
    @Query(value = "SELECT j.id_jugador, j.nombre, SUM(ej.goles) AS total_goles " +
            "FROM jugador j " +
            "JOIN estadisticas_jugador ej ON j.id_jugador = ej.id_jugador " +
            "GROUP BY j.id_jugador, j.nombre " +
            "HAVING SUM(ej.goles) > ?1", nativeQuery = true)
    List<Object[]> findJugadoresConMasDeXGoles(int goles);
}

