package Clinica.veterinaria.PetCare.domain.repository;

import Clinica.veterinaria.PetCare.domain.dto.RolDTO;
import java.util.List;
import java.util.Optional;

public interface RolRepository {
    List<RolDTO> getAll();
    Optional<RolDTO> getById(int id);
    RolDTO save(RolDTO rol);
    void delete(int id);
}
