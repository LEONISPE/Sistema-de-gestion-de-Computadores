package tcc_analisi_diseno_software.Model.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
@Getter
@Setter
public class Historial_de_uso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "computador_id", nullable = false)
    private Computador computador;
    private LocalDate fecha_uso = LocalDate.now();




    public Long getDuracion(){
        return ChronoUnit.DAYS.between(this.fecha_uso, LocalDate.now());
    }

    public Historial_de_uso() {
    }

    public Historial_de_uso(Long id, Computador computador, LocalDate fecha_uso) {
        this.id = id;
        this.computador = computador;
        this.fecha_uso = fecha_uso;
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

    public LocalDate getFecha_uso() {
        return fecha_uso;
    }

    public void setFecha_uso(LocalDate fecha_uso) {
        this.fecha_uso = fecha_uso;
    }
}
