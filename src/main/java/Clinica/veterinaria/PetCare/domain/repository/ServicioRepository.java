package Clinica.veterinaria.PetCare.domain.repository;

import Clinica.veterinaria.PetCare.domain.dto.ServicioDTO;
import java.util.List;
import java.util.Optional;

public interface ServicioRepository {
    List<ServicioDTO> getAll();
    Optional<ServicioDTO> getById(int id);
    List<ServicioDTO> getByEspecieDestino(String especie);
    ServicioDTO save(ServicioDTO servicio);
    void delete(int id);
}