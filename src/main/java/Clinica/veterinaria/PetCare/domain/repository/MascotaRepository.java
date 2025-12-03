package Clinica.veterinaria.PetCare.domain.repository;

import Clinica.veterinaria.PetCare.domain.dto.MascotaDTO;
import java.util.List;
import java.util.Optional;

public interface MascotaRepository {
    List<MascotaDTO> getAll();

    List<MascotaDTO> getByVeterinario(int idVeterinario);

    Optional<MascotaDTO> getById(int id);
    List<MascotaDTO> getByDueno(int idDueno);
    MascotaDTO save(MascotaDTO mascota);
    void delete(int id);
}