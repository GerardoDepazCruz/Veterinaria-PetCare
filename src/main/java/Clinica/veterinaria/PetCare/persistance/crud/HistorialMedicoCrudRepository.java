package Clinica.veterinaria.PetCare.persistance.crud;

import Clinica.veterinaria.PetCare.persistance.entity.HistorialMedico;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface HistorialMedicoCrudRepository extends CrudRepository<HistorialMedico, Integer> {
    List<HistorialMedico> findByMascotaIdMascota(Integer idMascota);
    List<HistorialMedico> findByVeterinarioIdUsuario(Integer idVeterinario);
}
