package Clinica.veterinaria.PetCare.domain.service;

import Clinica.veterinaria.PetCare.domain.dto.HistorialMedicoDTO;
import Clinica.veterinaria.PetCare.domain.dto.MascotaDTO;
import Clinica.veterinaria.PetCare.domain.repository.HistorialMedicoRepository;
import Clinica.veterinaria.PetCare.domain.repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MascotaService {

    @Autowired
    private MascotaRepository mascotaRepository;

    @Autowired
    private HistorialMedicoRepository historialMedicoRepository;

    public List<MascotaDTO> getAllMascotas() {
        return mascotaRepository.getAll();
    }

    public Optional<MascotaDTO> getMascotaById(int id) {
        return mascotaRepository.getById(id);
    }

    public List<MascotaDTO> getMascotasByDueno(int idDueno) {
        return mascotaRepository.getByDueno(idDueno);
    }

    public MascotaDTO saveMascota(MascotaDTO mascota) {
        if (mascota == null || mascota.getNombre() == null) {
            throw new IllegalArgumentException("Mascota inválida");
        }
        return mascotaRepository.save(mascota);
    }

    public void deleteMascota(int id) {
        mascotaRepository.delete(id);
    }

    public MascotaDTO updateMascota(int id, MascotaDTO dto) {
        Optional<MascotaDTO> existing = mascotaRepository.getById(id);
        if (existing.isEmpty()) {
            throw new RuntimeException("Mascota no encontrada");
        }
        MascotaDTO mascotaExistente = existing.get();
        mascotaExistente.setNombre(dto.getNombre());
        mascotaExistente.setEspecie(dto.getEspecie());
        mascotaExistente.setRaza(dto.getRaza());
        mascotaExistente.setEdad(dto.getEdad());
        mascotaExistente.setPeso(dto.getPeso());
        mascotaExistente.setIdDueno(dto.getIdDueno());
        return mascotaRepository.save(mascotaExistente);
    }
}
