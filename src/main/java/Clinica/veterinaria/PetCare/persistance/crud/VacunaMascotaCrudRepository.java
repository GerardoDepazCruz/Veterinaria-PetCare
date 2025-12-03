package Clinica.veterinaria.PetCare.persistance.crud;

import Clinica.veterinaria.PetCare.persistance.entity.VacunaMascota;
import Clinica.veterinaria.PetCare.persistance.entity.VacunaMascotaPK;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface VacunaMascotaCrudRepository extends CrudRepository<VacunaMascota, VacunaMascotaPK> {
    List<VacunaMascota> findByMascotaIdMascota(Integer idMascota);
    List<VacunaMascota> findByVeterinarioIdUsuario(Integer idVeterinario);
}
