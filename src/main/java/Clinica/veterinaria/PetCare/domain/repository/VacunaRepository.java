package Clinica.veterinaria.PetCare.domain.repository;

import Clinica.veterinaria.PetCare.domain.dto.VacunaDTO;
import java.util.List;
import java.util.Optional;

public interface VacunaRepository {
    List<VacunaDTO> getAll();
    Optional<VacunaDTO> getById(int id);
    VacunaDTO save(VacunaDTO vacuna);
    void delete(int id);
}
