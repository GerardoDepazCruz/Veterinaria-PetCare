package Clinica.veterinaria.PetCare.domain.service;

import Clinica.veterinaria.PetCare.domain.dto.CitaDTO;
import Clinica.veterinaria.PetCare.domain.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendarCitaService {

    @Autowired
    private CitaRepository citaRepository;

    public void agendarCita(CitaDTO citaDTO) {
        citaRepository.save(citaDTO);
    }
}
