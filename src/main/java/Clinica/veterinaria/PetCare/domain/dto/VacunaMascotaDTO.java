package Clinica.veterinaria.PetCare.domain.dto;

import java.time.LocalDate;

public class VacunaMascotaDTO {
    private Integer idMascota;
    private Integer idVacuna;
    private Integer idVeterinario;
    private LocalDate fecha;
    private String estado;

    // Getters
    public Integer getIdMascota() {
        return idMascota;
    }

    public Integer getIdVacuna() {
        return idVacuna;
    }

    public Integer getIdVeterinario() {
        return idVeterinario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getEstado() {
        return estado;
    }

    // Setters
    public void setIdMascota(Integer idMascota) {
        this.idMascota = idMascota;
    }

    public void setIdVacuna(Integer idVacuna) {
        this.idVacuna = idVacuna;
    }

    public void setIdVeterinario(Integer idVeterinario) {
        this.idVeterinario = idVeterinario;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
