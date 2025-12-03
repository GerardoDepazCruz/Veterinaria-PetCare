package Clinica.veterinaria.PetCare.persistance.repository;

import Clinica.veterinaria.PetCare.domain.dto.CitaDTO;
import Clinica.veterinaria.PetCare.domain.repository.CitaRepository;
import Clinica.veterinaria.PetCare.persistance.crud.CitaCrudRepository;
import Clinica.veterinaria.PetCare.persistance.entity.Cita;
import Clinica.veterinaria.PetCare.persistance.mapper.CitaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class CitaRepositoryImpl implements CitaRepository {

    @Autowired
    private CitaCrudRepository crud;

    @Autowired
    private CitaMapper mapper;

    @Override
    public List<CitaDTO> getAll() {
        return mapper.toDTOList((List<Cita>) crud.findAll());
    }

    @Override
    public Optional<CitaDTO> getById(int id) {
        return crud.findById(id).map(mapper::toDTO);
    }

    @Override
    public List<CitaDTO> getByVeterinario(int idVet) {
        return mapper.toDTOList(crud.findByVeterinarioIdUsuario(idVet));
    }

    @Override
    public List<CitaDTO> getByMascota(int idMascota) {
        return mapper.toDTOList(crud.findByMascotaIdMascota(idMascota));
    }

    @Override
    public CitaDTO save(CitaDTO cita) {
        Cita entity = mapper.toEntity(cita);
        return mapper.toDTO(crud.save(entity));
    }

    @Override
    public void delete(int id) {
        crud.deleteById(id);
    }
}