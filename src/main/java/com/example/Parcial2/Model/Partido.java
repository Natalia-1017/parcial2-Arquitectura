package com.example.Parcial2.Model;



import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "partido")
public class Partido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_partido")
    private Integer idPartido;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(length = 100, nullable = false)
    private String estadio;

    @ManyToOne
    @JoinColumn(name = "equipo_local", nullable = false)
    private Equipo equipoLocal;

    @ManyToOne
    @JoinColumn(name = "equipo_visita", nullable = false)
    private Equipo equipoVisita;

    @Column(name = "goles_local")
    private Integer golesLocal;

    @Column(name = "goles_visita")
    private Integer golesVisita;


    public Partido() {
    }

    public Partido(Integer idPartido, LocalDate fecha, String estadio, Equipo equipoLocal,
                   Equipo equipoVisita, Integer golesLocal, Integer golesVisita) {
        this.idPartido = idPartido;
        this.fecha = fecha;
        this.estadio = estadio;
        this.equipoLocal = equipoLocal;
        this.equipoVisita = equipoVisita;
        this.golesLocal = golesLocal;
        this.golesVisita = golesVisita;
    }


    public Integer getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(Integer idPartido) {
        this.idPartido = idPartido;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public Equipo getEquipoVisita() {
        return equipoVisita;
    }

    public void setEquipoVisita(Equipo equipoVisita) {
        this.equipoVisita = equipoVisita;
    }

    public Integer getGolesLocal() {
        return golesLocal;
    }

    public void setGolesLocal(Integer golesLocal) {
        this.golesLocal = golesLocal;
    }

    public Integer getGolesVisita() {
        return golesVisita;
    }

    public void setGolesVisita(Integer golesVisita) {
        this.golesVisita = golesVisita;
    }


    @Override
    public String toString() {
        return "Partido{" +
                "idPartido=" + idPartido +
                ", fecha=" + fecha +
                ", estadio='" + estadio + '\'' +
                ", equipoLocal=" + (equipoLocal != null ? equipoLocal.getNombre() : "null") +
                ", equipoVisita=" + (equipoVisita != null ? equipoVisita.getNombre() : "null") +
                ", golesLocal=" + golesLocal +
                ", golesVisita=" + golesVisita +
                '}';
    }
}
