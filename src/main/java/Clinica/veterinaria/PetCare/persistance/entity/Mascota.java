package Clinica.veterinaria.PetCare.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "mascota")
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mascota")
    private Integer idMascota;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(length = 50)
    private String especie;

    @Column(length = 100)
    private String raza;

    private Integer edad;

    private BigDecimal peso;

    // Relación con Usuario (Dueño)
    @ManyToOne
    @JoinColumn(name = "id_dueno")
    private Usuario dueno;

    // Relación con Cita
    @OneToMany(mappedBy = "mascota")
    private List<Cita> citas;

    // Relación con Historial Médico
    @OneToMany(mappedBy = "mascota")
    private List<HistorialMedico> historiales;

    // Relación con Vacunas
    @OneToMany(mappedBy = "mascota")
    private List<VacunaMascota> vacunas;
}
