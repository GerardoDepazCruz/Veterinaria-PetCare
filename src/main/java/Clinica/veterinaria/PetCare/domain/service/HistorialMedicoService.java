package Clinica.veterinaria.PetCare.domain.service;

import Clinica.veterinaria.PetCare.domain.dto.HistorialMedicoDTO;
import Clinica.veterinaria.PetCare.domain.repository.HistorialMedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistorialMedicoService {

    @Autowired
    private HistorialMedicoRepository historialRepository;

    public List<HistorialMedicoDTO> getAllHistoriales() {
        return historialRepository.getAll();
    }

    public Optional<HistorialMedicoDTO> getHistorialById(int id) {
        return historialRepository.getById(id);
    }

    public List<HistorialMedicoDTO> getHistorialesByMascota(int idMascota) {
        return historialRepository.getByMascota(idMascota);
    }

    public List<HistorialMedicoDTO> getHistorialesByVeterinario(int idVet) {
        return historialRepository.getByVeterinario(idVet);
    }

    public List<HistorialMedicoDTO> searchByVeterinarioAndNombreMascota(int idVet, String nombreMascota) {
        return historialRepository.searchByVeterinarioAndNombreMascota(idVet, nombreMascota);
    }

    public HistorialMedicoDTO saveHistorial(HistorialMedicoDTO historial) {
        if (historial == null || historial.getDescripcion() == null) {
            throw new IllegalArgumentException("Historial inválido");
        }
        return historialRepository.save(historial);
    }

    public void deleteHistorial(int id) {
        historialRepository.delete(id);
    }
}
