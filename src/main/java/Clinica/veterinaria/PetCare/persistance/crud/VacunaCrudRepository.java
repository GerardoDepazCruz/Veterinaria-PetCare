package Clinica.veterinaria.PetCare.persistance.crud;

import Clinica.veterinaria.PetCare.persistance.entity.Vacuna;
import org.springframework.data.repository.CrudRepository;

public interface VacunaCrudRepository extends CrudRepository<Vacuna, Integer> {
}
