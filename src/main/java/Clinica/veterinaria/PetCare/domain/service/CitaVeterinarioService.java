package Clinica.veterinaria.PetCare.domain.service;

import Clinica.veterinaria.PetCare.domain.dto.CitaDTO;
import Clinica.veterinaria.PetCare.domain.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitaVeterinarioService {

    @Autowired
    private CitaRepository citaRepository;

    public List<CitaDTO> getCitasByVeterinario(int idVeterinario) {
        return citaRepository.getByVeterinario(idVeterinario);
    }
}
