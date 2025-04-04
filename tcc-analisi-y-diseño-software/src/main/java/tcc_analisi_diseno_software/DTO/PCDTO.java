package tcc_analisi_diseno_software.DTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import tcc_analisi_diseno_software.Model.Entities.Ubicacion;

import java.time.LocalDate;


public class PCDTO {
    private Long id;
    @NotNull(message = "la marca del pc no puede ser nula")
    private String marca;
    @NotNull(message = "el modelo  del pc no puede ser nula")
    private String modelo;
    @NotNull(message = "el numero-de-serie del pc no puede ser nula")
    private String numero_serie;
    @NotNull(message = "la ubicacion  del pc no puede ser nula")
    private Ubicacion ubicacion;
    @NotNull(message = "la fecha de adquisicion  del pc no puede ser nula")
    private LocalDate fecha_adquisicion;
    @NotNull(message = "el estado o activo no debe ser nulo")
    private Boolean activo;

    public PCDTO(Long id,String marca, String modelo, String numero_serie, Ubicacion ubicacion, LocalDate fecha_adquisicion,boolean activo) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.numero_serie = numero_serie;
        this.ubicacion = ubicacion;
        this.fecha_adquisicion = fecha_adquisicion;
        this.activo = activo;
    }



    public  String getActivo() {
        return activo ? "Si":"No";
    }


    public Long getId() {
        return id;
    }
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNumero_serie() {
        return numero_serie;
    }

    public void setNumero_serie(String numero_serie) {
        this.numero_serie = numero_serie;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public LocalDate getFecha_adquisicion() {
        return fecha_adquisicion;
    }

    public void setFecha_adquisicion(LocalDate fecha_adquisicion) {
        this.fecha_adquisicion = fecha_adquisicion;
    }

    @JsonIgnore  // Esto oculta el método en la respuesta JSON
    public Boolean isActivoBoolean() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}
