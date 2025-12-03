package Clinica.veterinaria.PetCare.persistance.repository;

import Clinica.veterinaria.PetCare.domain.dto.RolDTO;
import Clinica.veterinaria.PetCare.domain.repository.RolRepository;
import Clinica.veterinaria.PetCare.persistance.crud.RolCrudRepository;
import Clinica.veterinaria.PetCare.persistance.entity.Rol;
import Clinica.veterinaria.PetCare.persistance.mapper.RolMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class RolRepositoryImpl implements RolRepository {

    @Autowired
    private RolCrudRepository crud;

    @Autowired
    private RolMapper mapper;

    @Override
    public List<RolDTO> getAll() {
        return mapper.toDTOList((List<Rol>) crud.findAll());
    }

    @Override
    public Optional<RolDTO> getById(int id) {
        return crud.findById(id).map(mapper::toDTO);
    }

    @Override
    public RolDTO save(RolDTO rol) {
        Rol entity = mapper.toEntity(rol);
        return mapper.toDTO(crud.save(entity));
    }

    @Override
    public void delete(int id) {
        crud.deleteById(id);
    }
}
