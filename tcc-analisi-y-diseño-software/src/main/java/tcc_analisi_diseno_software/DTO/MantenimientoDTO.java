package tcc_analisi_diseno_software.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import tcc_analisi_diseno_software.Model.Entities.Computador;

import java.time.LocalDate;

public class MantenimientoDTO {
    private Long id;
    @NotNull(message = "debe selecionar el id del pc")
    private Computador computador;
    @NotNull(message = "debe poner una descripcion ")
    private String descripcion_mantenimiento;
    private LocalDate fecha_mantenimiento = LocalDate.now();
    @NotNull(message = "debe selecionar el nombre del responsable ")
    private String responsable;
    @NotNull(message = "debe selecional la fecha de mantenimiento del pc ")
    private LocalDate fecha_programada;

    public MantenimientoDTO( Long id,Computador computador, String descripcion_mantenimiento, LocalDate fecha_mantenimiento, String responsable, LocalDate fecha_programada) {
        this.computador = computador;
        this.descripcion_mantenimiento = descripcion_mantenimiento;
        this.fecha_mantenimiento = fecha_mantenimiento;
        this.responsable = responsable;
        this.fecha_programada = fecha_programada;
        this.id = id;
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

    public LocalDate getFecha_mantenimiento() {
        return fecha_mantenimiento;
    }

    public void setFecha_mantenimiento(LocalDate fecha_mantenimiento) {
        this.fecha_mantenimiento = fecha_mantenimiento;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public LocalDate getFecha_programada() {
        return fecha_programada;
    }

    public void setFecha_programada(LocalDate fecha_programada) {
        this.fecha_programada = fecha_programada;
    }
}
