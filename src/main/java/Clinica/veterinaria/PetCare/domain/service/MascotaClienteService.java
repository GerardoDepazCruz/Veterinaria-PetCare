package Clinica.veterinaria.PetCare.domain.service;

import Clinica.veterinaria.PetCare.domain.dto.MascotaDTO;
import Clinica.veterinaria.PetCare.domain.repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MascotaClienteService {

    @Autowired
    private MascotaRepository mascotaRepository;

    public List<MascotaDTO> getMascotasByUsuario(int idUsuario) {
        return mascotaRepository.getByDueno(idUsuario); // Usar getByDueno en vez de getByUsuario
    }

    public Optional<MascotaDTO> getMascotaById(int id) {
        return mascotaRepository.getById(id);
    }

    public MascotaDTO saveMascota(MascotaDTO mascota) {
        return mascotaRepository.save(mascota);
    }

    public void deleteMascota(int id) {
        mascotaRepository.delete(id);
    }
}

