package Clinica.veterinaria.PetCare.domain.service;

import Clinica.veterinaria.PetCare.domain.dto.CitaDTO;
import Clinica.veterinaria.PetCare.domain.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitaService {

    @Autowired
    private CitaRepository citaRepository;

    public List<CitaDTO> getAllCitas() {
        return citaRepository.getAll();
    }

    public Optional<CitaDTO> getCitaById(int id) {
        return citaRepository.getById(id);
    }

    public List<CitaDTO> getCitasByVeterinario(int idVet) {
        return citaRepository.getByVeterinario(idVet);
    }

    public List<CitaDTO> getCitasByMascota(int idMascota) {
        return citaRepository.getByMascota(idMascota);
    }

    public CitaDTO saveCita(CitaDTO cita) {
        if (cita == null || cita.getFecha() == null || cita.getHora() == null) {
            throw new IllegalArgumentException("Fecha y hora son obligatorias");
        }
        return citaRepository.save(cita);
    }

    public CitaDTO updateCita(int id, CitaDTO dto) {
        Optional<CitaDTO> existing = citaRepository.getById(id);
        if (existing.isEmpty()) {
            throw new RuntimeException("Cita no encontrada");
        }
        CitaDTO citaExistente = existing.get();

        citaExistente.setFecha(dto.getFecha());
        citaExistente.setHora(dto.getHora());
        citaExistente.setEstado(dto.getEstado());
        citaExistente.setIdMascota(dto.getIdMascota());
        citaExistente.setIdServicio(dto.getIdServicio());
        citaExistente.setIdVeterinario(dto.getIdVeterinario());

        return citaRepository.save(citaExistente);
    }

    public void deleteCita(int id) {
        if (!citaRepository.getById(id).isPresent()) {
            throw new RuntimeException("Cita no encontrada");
        }
        citaRepository.delete(id);
    }

    public List<CitaDTO> searchCitas(String keyword) {
        String kwLower = keyword.trim().toLowerCase();
        return getAllCitas().stream()
                .filter(cita -> cita.getEstado() != null && cita.getEstado().toLowerCase().contains(kwLower))
                .toList();
    }
}
