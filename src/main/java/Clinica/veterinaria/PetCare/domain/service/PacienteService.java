package Clinica.veterinaria.PetCare.domain.service;

import Clinica.veterinaria.PetCare.domain.dto.HistorialMedicoDTO;
import Clinica.veterinaria.PetCare.domain.dto.MascotaDTO;
import Clinica.veterinaria.PetCare.domain.dto.VacunaDTO;
import Clinica.veterinaria.PetCare.domain.repository.HistorialMedicoRepository;
import Clinica.veterinaria.PetCare.domain.repository.MascotaRepository;
import Clinica.veterinaria.PetCare.domain.repository.VacunaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PacienteService {

    @Autowired
    private MascotaRepository mascotaRepository;

    @Autowired
    private HistorialMedicoRepository historialMedicoRepository;

    @Autowired
    private VacunaRepository vacunaRepository;
    public List<VacunaDTO> getVacunasDisponibles(int idMascota) {
        // opcional: filtra vacunas ya aplicadas a la mascota
        List<VacunaDTO> todas = vacunaRepository.getAll();
        List<HistorialMedicoDTO> aplicadas = historialMedicoRepository.getByMascota(idMascota);
        return todas.stream()
                .filter(v -> aplicadas.stream().noneMatch(h -> h.getDescripcion().contains(v.getNombre())))
                .collect(Collectors.toList());
    }
    public List<MascotaDTO> getAllMascotas() {
        return mascotaRepository.getAll();
    }

    public Optional<MascotaDTO> getMascotaById(int id) {
        return mascotaRepository.getById(id);
    }

    // Historial
    public List<HistorialMedicoDTO> getHistorialesByMascota(int idMascota) {
        // Asegúrate que el repositorio tenga un método que busque por idMascota
        return historialMedicoRepository.findByIdMascota(idMascota);
    }

    public HistorialMedicoDTO crearHistorialClinico(int idMascota, String descripcion, int idVeterinario) {
        HistorialMedicoDTO historial = new HistorialMedicoDTO();
        historial.setIdMascota(idMascota);
        historial.setDescripcion(descripcion);
        historial.setIdVeterinario(idVeterinario);
        historial.setFecha(LocalDate.now());
        return historialMedicoRepository.save(historial);
    }

    public List<MascotaDTO> getMascotasByVeterinario(int idVeterinario) {
        return mascotaRepository.getByVeterinario(idVeterinario);
    }


    public void deleteHistorial(int idHistorial) {
        historialMedicoRepository.deleteById(idHistorial);
    }

    // Vacunas
    public List<VacunaDTO> getVacunasPorMascota(int idMascota) {
        // Todas las vacunas
        List<VacunaDTO> todas = vacunaRepository.getAll();

        // Vacunas ya aplicadas a la mascota
        List<HistorialMedicoDTO> aplicadas = historialMedicoRepository.findByIdMascota(idMascota)
                .stream()
                .filter(h -> h.getDescripcion().startsWith("Vacuna aplicada:"))
                .collect(Collectors.toList());

        List<String> nombresAplicadas = aplicadas.stream()
                .map(h -> h.getDescripcion().replace("Vacuna aplicada: ", ""))
                .collect(Collectors.toList());

        // Retornar solo las vacunas pendientes
        return todas.stream()
                .filter(v -> !nombresAplicadas.contains(v.getNombre()))
                .collect(Collectors.toList());
    }

    public void aplicarVacunaAMascota(int idMascota, VacunaDTO vacuna, int idVeterinario) {
        HistorialMedicoDTO registroVacuna = new HistorialMedicoDTO();
        registroVacuna.setIdMascota(idMascota);
        registroVacuna.setIdVeterinario(idVeterinario);
        registroVacuna.setFecha(LocalDate.now());
        registroVacuna.setDescripcion("Vacuna aplicada: " + vacuna.getNombre());
        historialMedicoRepository.save(registroVacuna);
    }
}
