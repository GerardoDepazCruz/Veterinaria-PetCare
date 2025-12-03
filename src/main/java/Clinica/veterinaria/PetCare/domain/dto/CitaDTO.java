package Clinica.veterinaria.PetCare.domain.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class CitaDTO {
    private Integer id;
    private LocalDate fecha;
    private LocalTime hora;
    private String estado;
    private Integer idMascota;
    private String nombreMascota;
    private Integer idServicio;
    private String nombreServicio;
    private Integer idVeterinario;
    private String nombreVeterinario;

    // Getters
    public Integer getId() {
        return id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public String getEstado() {
        return estado;
    }

    public Integer getIdMascota() {
        return idMascota;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public Integer getIdServicio() {
        return idServicio;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public Integer getIdVeterinario() {
        return idVeterinario;
    }

    public String getNombreVeterinario() {
        return nombreVeterinario;
    }

    // Setters
    public void setId(Integer id) {
        this.id = id;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setIdMascota(Integer idMascota) {
        this.idMascota = idMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public void setIdVeterinario(Integer idVeterinario) {
        this.idVeterinario = idVeterinario;
    }

    public void setNombreVeterinario(String nombreVeterinario) {
        this.nombreVeterinario = nombreVeterinario;
    }
}
