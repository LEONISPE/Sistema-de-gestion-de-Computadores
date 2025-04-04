package tcc_analisi_diseno_software.DTO;

import jakarta.validation.constraints.NotNull;
import tcc_analisi_diseno_software.Model.Entities.Computador;

import java.time.LocalDate;

public class Historial_de_uso {

    @NotNull(message = "debe selecionar el id del pc")
    private Computador computador;

    private LocalDate fecha_uso = LocalDate.now();

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
