package Clinica.veterinaria.PetCare.persistance.repository;

import Clinica.veterinaria.PetCare.domain.dto.VacunaDTO;
import Clinica.veterinaria.PetCare.domain.repository.VacunaRepository;
import Clinica.veterinaria.PetCare.persistance.crud.VacunaCrudRepository;
import Clinica.veterinaria.PetCare.persistance.entity.Vacuna;
import Clinica.veterinaria.PetCare.persistance.mapper.VacunaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class VacunaRepositoryImpl implements VacunaRepository {

    @Autowired
    private VacunaCrudRepository crud;

    @Autowired
    private VacunaMapper mapper;

    @Override
    public List<VacunaDTO> getAll() {
        return mapper.toDTOList((List<Vacuna>) crud.findAll());
    }

    @Override
    public Optional<VacunaDTO> getById(int id) {
        return crud.findById(id).map(mapper::toDTO);
    }

    @Override
    public VacunaDTO save(VacunaDTO vacuna) {
        Vacuna entity = mapper.toEntity(vacuna);
        return mapper.toDTO(crud.save(entity));
    }

    @Override
    public void delete(int id) {
        crud.deleteById(id);
    }
}