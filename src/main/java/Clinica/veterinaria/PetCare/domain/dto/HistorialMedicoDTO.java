package Clinica.veterinaria.PetCare.domain.dto;

import java.time.LocalDate;

public class HistorialMedicoDTO {
    private Integer id;
    private String descripcion;
    private LocalDate fecha;
    private Integer idMascota;
    private String nombreMascota;
    private Integer idVeterinario;
    private String nombreVeterinario;

    public HistorialMedicoDTO(Integer id, String nombreVeterinario, Integer idVeterinario, String nombreMascota, Integer idMascota, LocalDate fecha, String descripcion) {
        this.id = id;
        this.nombreVeterinario = nombreVeterinario;
        this.idVeterinario = idVeterinario;
        this.nombreMascota = nombreMascota;
        this.idMascota = idMascota;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public HistorialMedicoDTO() {
    }

    // Getters
    public Integer getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Integer getIdMascota() {
        return idMascota;
    }

    public String getNombreMascota() {
        return nombreMascota;
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

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setIdMascota(Integer idMascota) {
        this.idMascota = idMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public void setIdVeterinario(Integer idVeterinario) {
        this.idVeterinario = idVeterinario;
    }

    public void setNombreVeterinario(String nombreVeterinario) {
        this.nombreVeterinario = nombreVeterinario;
    }
}
