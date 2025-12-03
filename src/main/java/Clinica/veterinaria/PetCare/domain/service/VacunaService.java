package Clinica.veterinaria.PetCare.domain.service;

import Clinica.veterinaria.PetCare.domain.dto.VacunaDTO;
import Clinica.veterinaria.PetCare.domain.repository.VacunaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VacunaService {

    @Autowired
    private VacunaRepository vacunaRepository;
    public List<VacunaDTO> getAllVacunas() {
        return vacunaRepository.getAll();
    }
    public Optional<VacunaDTO> getVacunaById(int id) {
        return vacunaRepository.getById(id);
    }
    public VacunaDTO saveVacuna(VacunaDTO vacuna) {
        if (vacuna == null || vacuna.getNombre() == null) {
            throw new IllegalArgumentException("Vacuna inválida");
        }
        return vacunaRepository.save(vacuna);
    }
    public void deleteVacuna(int id) {
        vacunaRepository.delete(id);
    }

}
