package Clinica.veterinaria.PetCare.domain.repository;

import Clinica.veterinaria.PetCare.domain.dto.CitaDTO;
import java.util.List;
import java.util.Optional;


public interface CitaRepository {
    List<CitaDTO> getAll();
    Optional<CitaDTO> getById(int id);
    List<CitaDTO> getByVeterinario(int idVet);
    List<CitaDTO> getByMascota(int idMascota);
    CitaDTO save(CitaDTO cita);
    void delete(int id);
}