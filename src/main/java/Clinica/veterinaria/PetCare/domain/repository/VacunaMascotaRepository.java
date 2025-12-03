package Clinica.veterinaria.PetCare.domain.repository;

import Clinica.veterinaria.PetCare.domain.dto.VacunaMascotaDTO;
import java.util.List;

public interface VacunaMascotaRepository {
    List<VacunaMascotaDTO> getAll();
    List<VacunaMascotaDTO> getByMascota(int idMascota);
    List<VacunaMascotaDTO> getByVeterinario(int idVet);
    VacunaMascotaDTO save(VacunaMascotaDTO vacunaMascota);
}
