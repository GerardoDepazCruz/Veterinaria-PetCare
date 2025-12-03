package Clinica.veterinaria.PetCare.persistance.crud;

import Clinica.veterinaria.PetCare.persistance.entity.Mascota;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface MascotaCrudRepository extends CrudRepository<Mascota, Integer> {
    List<Mascota> findByEspecie(String especie);
    List<Mascota> findByDuenoIdUsuario(Integer idDueno);

    @Query("SELECT c.mascota FROM Cita c WHERE c.veterinario.idUsuario = :idVeterinario")
    List<Mascota> findMascotasByVeterinario(int idVeterinario);
}