package Clinica.veterinaria.PetCare.persistance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class VacunaMascotaPK implements Serializable {

    @Column(name = "id_mascota")
    private Integer idMascota;

    @Column(name = "id_vacuna")
    private Integer idVacuna;

    @Column(name = "id_veterinario")
    private Integer idVeterinario;

    // Requerido por JPA para PK compuestas
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VacunaMascotaPK that)) return false;
        return Objects.equals(idMascota, that.idMascota) &&
                Objects.equals(idVacuna, that.idVacuna) &&
                Objects.equals(idVeterinario, that.idVeterinario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMascota, idVacuna, idVeterinario);
    }
}
