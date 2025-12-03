package Clinica.veterinaria.PetCare.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "vacuna_mascota")
public class VacunaMascota {

    @EmbeddedId
    private VacunaMascotaPK id;

    @Column(nullable = false)
    private LocalDate fecha;

    @Enumerated(EnumType.STRING)
    private EstadoVacuna estado = EstadoVacuna.pendiente;

    // Relaciones con entidades principales usando la PK compuesta
    @MapsId("idMascota")
    @ManyToOne
    @JoinColumn(name = "id_mascota", insertable = false, updatable = false)
    private Mascota mascota;

    @MapsId("idVacuna")
    @ManyToOne
    @JoinColumn(name = "id_vacuna", insertable = false, updatable = false)
    private Vacuna vacuna;

    @MapsId("idVeterinario")
    @ManyToOne
    @JoinColumn(name = "id_veterinario", insertable = false, updatable = false)
    private Usuario veterinario;

    public enum EstadoVacuna {
        pendiente, aplicada
    }
}
