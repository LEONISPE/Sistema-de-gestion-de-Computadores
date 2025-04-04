package tcc_analisi_diseno_software.Model.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Mantenimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "computador_id",nullable = false)
    private Computador computador;
    private String descripcion_mantenimiento;
    private LocalDate fecha_mantenimiento = LocalDate.now();
    private String responsable;
    private LocalDate fecha_programada;
    private Boolean programado;



    public LocalDate getFecha_mantenimiento() {
        return fecha_mantenimiento;
    }

    public void setFecha_mantenimiento(LocalDate fecha_mantenimiento) {
        this.fecha_mantenimiento = fecha_mantenimiento;
    }


    public LocalDate getFecha_programada() {
        return fecha_programada;
    }

    public void setFecha_programada(LocalDate fecha_programada) {
        this.fecha_programada = fecha_programada;
    }

    public Boolean getProgramado() {
        return programado;
    }

    public void setProgramado(Boolean programado) {
        this.programado = programado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Computador getComputador() {
        return computador;
    }

    public void setComputador(Computador computador) {
        this.computador = computador;
    }

    public String getDescripcion_mantenimiento() {
        return descripcion_mantenimiento;
    }

    public void setDescripcion_mantenimiento(String descripcion_mantenimiento) {
        this.descripcion_mantenimiento = descripcion_mantenimiento;
    }



    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }
}
