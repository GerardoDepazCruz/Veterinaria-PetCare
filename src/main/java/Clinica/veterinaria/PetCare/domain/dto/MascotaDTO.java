package Clinica.veterinaria.PetCare.domain.dto;

import java.math.BigDecimal;

public class MascotaDTO {
    private Integer id;
    private String nombre;
    private String especie;
    private String raza;
    private Integer edad;
    private BigDecimal peso;
    private Integer idDueno;
    private String nombreDueno;

    public MascotaDTO(Integer id, String nombreDueno, Integer idDueno, BigDecimal peso, Integer edad, String especie, String nombre, String raza) {
        this.id = id;
        this.nombreDueno = nombreDueno;
        this.idDueno = idDueno;
        this.peso = peso;
        this.edad = edad;
        this.especie = especie;
        this.nombre = nombre;
        this.raza = raza;
    }

    public MascotaDTO() {
    }

    // Getters
    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public String getRaza() {
        return raza;
    }

    public Integer getEdad() {
        return edad;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public Integer getIdDueno() {
        return idDueno;
    }

    public String getNombreDueno() {
        return nombreDueno;
    }

    // Setters
    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public void setIdDueno(Integer idDueno) {
        this.idDueno = idDueno;
    }

    public void setNombreDueno(String nombreDueno) {
        this.nombreDueno = nombreDueno;
    }
}
