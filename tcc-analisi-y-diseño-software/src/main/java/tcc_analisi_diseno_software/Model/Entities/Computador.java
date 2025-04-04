package tcc_analisi_diseno_software.Model.Entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Computador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    @OneToMany(mappedBy = "computador",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Mantenimiento> mantenimientos;
    @OneToOne(mappedBy = "computador", cascade = CascadeType.ALL, orphanRemoval = true)
    private Historial_de_uso historialUso;  // Solo un historial por PC
    private String modelo;
    @Column(unique=true, nullable=false)
    private String numero_serie;
    @ManyToOne
    @JoinColumn(name = "ubicacion_id", nullable = false)

    private Ubicacion ubicacion;
    private LocalDate fecha_adquisicion;
    private Boolean activo;

    public Computador(Long id, String marca, List<Mantenimiento> mantenimientos, Historial_de_uso historialUso, String modelo, String numero_serie, Ubicacion ubicacion, LocalDate fecha_adquisicion ,Boolean activo) {
        this.id = id;
        this.marca = marca;
        this.mantenimientos = mantenimientos;
        this.historialUso = historialUso;
        this.modelo = modelo;
        this.numero_serie = numero_serie;
        this.ubicacion = ubicacion;
        this.fecha_adquisicion = fecha_adquisicion;
        this.activo = activo;
    }


    public Computador() {
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }


    public List<Mantenimiento> getMantenimientos() {
        return mantenimientos;
    }

    public void setMantenimientos(List<Mantenimiento> mantenimientos) {
        this.mantenimientos = mantenimientos;
    }

    public Historial_de_uso getHistorialUso() {
        return historialUso;
    }

    public void setHistorialUso(Historial_de_uso historialUso) {
        this.historialUso = historialUso;
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

    public void desactivarPc(){
        this.activo = false;
    }
    public void activarPc(){
        this.activo = true;
    }

}
