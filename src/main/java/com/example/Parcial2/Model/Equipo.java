package com.example.Parcial2.Model;


import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "equipo")
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_equipo")
    private Long idEquipo;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "ciudad", length = 100, nullable = false)
    private String ciudad;

    @Column(name = "fundacion")
    private LocalDate fundacion;

    // Relaciones

    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL)
    private List<Jugador> jugadores;

    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL)
    private List<Entrenador> entrenadores;

    @OneToMany(mappedBy = "equipoLocal", cascade = CascadeType.ALL)
    private List<Partido> partidosComoLocal;

    @OneToMany(mappedBy = "equipoVisitante", cascade = CascadeType.ALL)
    private List<Partido> partidosComoVisitante;

    public Equipo() {
    }

    public Equipo(Long idEquipo, String nombre, String ciudad, LocalDate fundacion, List<Jugador> jugadores, List<Entrenador> entrenadores, List<Partido> partidosComoLocal, List<Partido> partidosComoVisitante) {
        this.idEquipo = idEquipo;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.fundacion = fundacion;
        this.jugadores = jugadores;
        this.entrenadores = entrenadores;
        this.partidosComoLocal = partidosComoLocal;
        this.partidosComoVisitante = partidosComoVisitante;
    }

    public Long getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Long idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public LocalDate getFundacion() {
        return fundacion;
    }

    public void setFundacion(LocalDate fundacion) {
        this.fundacion = fundacion;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public List<Entrenador> getEntrenadores() {
        return entrenadores;
    }

    public void setEntrenadores(List<Entrenador> entrenadores) {
        this.entrenadores = entrenadores;
    }

    public List<Partido> getPartidosComoLocal() {
        return partidosComoLocal;
    }

    public void setPartidosComoLocal(List<Partido> partidosComoLocal) {
        this.partidosComoLocal = partidosComoLocal;
    }

    public List<Partido> getPartidosComoVisitante() {
        return partidosComoVisitante;
    }

    public void setPartidosComoVisitante(List<Partido> partidosComoVisitante) {
        this.partidosComoVisitante = partidosComoVisitante;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "idEquipo=" + idEquipo +
                ", nombre='" + nombre + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", fundacion=" + fundacion +
                ", jugadores=" + jugadores +
                ", entrenadores=" + entrenadores +
                ", partidosComoLocal=" + partidosComoLocal +
                ", partidosComoVisitante=" + partidosComoVisitante +
                '}';
    }
}

