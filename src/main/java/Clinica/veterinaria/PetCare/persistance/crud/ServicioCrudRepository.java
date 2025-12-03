package Clinica.veterinaria.PetCare.persistance.crud;

import Clinica.veterinaria.PetCare.persistance.entity.Servicio;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ServicioCrudRepository extends CrudRepository<Servicio, Integer> {
    List<Servicio> findByEspecieDestino(String especieDestino);
}