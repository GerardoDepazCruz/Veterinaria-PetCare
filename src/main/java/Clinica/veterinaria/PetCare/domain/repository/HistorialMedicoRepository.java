package Clinica.veterinaria.PetCare.domain.repository;

import Clinica.veterinaria.PetCare.domain.dto.HistorialMedicoDTO;
import java.util.List;
import java.util.Optional;

public interface HistorialMedicoRepository {
    List<HistorialMedicoDTO> getAll();
    Optional<HistorialMedicoDTO> getById(int id);
    List<HistorialMedicoDTO> getByMascota(int idMascota);
    List<HistorialMedicoDTO> getByVeterinario(int idVet);
    HistorialMedicoDTO save(HistorialMedicoDTO historial);
    void delete(int id);
    List<HistorialMedicoDTO> searchByVeterinarioAndNombreMascota(int idVet, String nombreMascota);

    // 🔹 Nuevos métodos requeridos
    List<HistorialMedicoDTO> findByIdMascota(int idMascota);
    void deleteById(int idHistorial);
    String getDescripcion(int idHistorial);
}
