package Clinica.veterinaria.PetCare.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "historial_medico")
public class HistorialMedico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_historial")
    private Integer idHistorial;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String descripcion;

    @Column(nullable = false)
    private LocalDate fecha;

    // Relación con Mascota
    @ManyToOne
    @JoinColumn(name = "id_mascota")
    private Mascota mascota;

    // Relación con Usuario (Veterinario)
    @ManyToOne
    @JoinColumn(name = "id_veterinario")
    private Usuario veterinario;
}
