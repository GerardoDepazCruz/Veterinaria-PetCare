package Clinica.veterinaria.PetCare.domain.service;

import Clinica.veterinaria.PetCare.domain.dto.ServicioDTO;
import Clinica.veterinaria.PetCare.domain.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioService {

    @Autowired
    private ServicioRepository servicioRepository;
    public List<ServicioDTO> getAllServicios() {
        return servicioRepository.getAll();
    }
    public Optional<ServicioDTO> getServicioById(int id) {
        return servicioRepository.getById(id);
    }
    public List<ServicioDTO> getServiciosByEspecie(String especie) {
        return servicioRepository.getByEspecieDestino(especie);
    }
    public ServicioDTO saveServicio(ServicioDTO servicio) {
        if (servicio == null || servicio.getNombre() == null) {
            throw new IllegalArgumentException("Servicio inválido");
        }
        return servicioRepository.save(servicio);
    }
    public void deleteServicio(int id) {
        servicioRepository.delete(id);
    }

}

