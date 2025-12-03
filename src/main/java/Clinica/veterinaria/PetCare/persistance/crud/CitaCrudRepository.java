package Clinica.veterinaria.PetCare.persistance.crud;

import Clinica.veterinaria.PetCare.persistance.entity.Cita;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CitaCrudRepository extends CrudRepository<Cita, Integer> {
    List<Cita> findByVeterinarioIdUsuario(Integer idVeterinario);
    List<Cita> findByMascotaIdMascota(Integer idMascota);
}
