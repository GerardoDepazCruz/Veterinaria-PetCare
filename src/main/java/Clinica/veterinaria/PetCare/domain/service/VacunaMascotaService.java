package Clinica.veterinaria.PetCare.domain.service;

import Clinica.veterinaria.PetCare.domain.dto.VacunaMascotaDTO;
import Clinica.veterinaria.PetCare.domain.repository.VacunaMascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VacunaMascotaService {

    @Autowired
    private VacunaMascotaRepository vacunaMascotaRepository;
    public List<VacunaMascotaDTO> getAllVacunasMascota() {
        return vacunaMascotaRepository.getAll();
    }
    public List<VacunaMascotaDTO> getVacunasByMascota(int idMascota) {
        return vacunaMascotaRepository.getByMascota(idMascota);
    }
    public List<VacunaMascotaDTO> getVacunasByVeterinario(int idVet) {
        return vacunaMascotaRepository.getByVeterinario(idVet);
    }
    public VacunaMascotaDTO saveVacunaMascota(VacunaMascotaDTO dto) {
        if (dto == null || dto.getFecha() == null) {
            throw new IllegalArgumentException("Vacuna mascota inválida");
        }
        return vacunaMascotaRepository.save(dto);
    }

}
