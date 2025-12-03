package Clinica.veterinaria.PetCare.persistance.repository;

import Clinica.veterinaria.PetCare.domain.dto.ServicioDTO;
import Clinica.veterinaria.PetCare.domain.repository.ServicioRepository;
import Clinica.veterinaria.PetCare.persistance.crud.ServicioCrudRepository;
import Clinica.veterinaria.PetCare.persistance.entity.Servicio;
import Clinica.veterinaria.PetCare.persistance.mapper.ServicioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class ServicioRepositoryImpl implements ServicioRepository {

    @Autowired
    private ServicioCrudRepository crud;

    @Autowired
    private ServicioMapper mapper;

    @Override
    public List<ServicioDTO> getAll() {
        return mapper.toDTOList((List<Servicio>) crud.findAll());
    }

    @Override
    public Optional<ServicioDTO> getById(int id) {
        return crud.findById(id).map(mapper::toDTO);
    }

    @Override
    public List<ServicioDTO> getByEspecieDestino(String especie) {
        return mapper.toDTOList(crud.findByEspecieDestino(especie));
    }

    @Override
    public ServicioDTO save(ServicioDTO servicio) {
        Servicio entity = mapper.toEntity(servicio);
        return mapper.toDTO(crud.save(entity));
    }

    @Override
    public void delete(int id) {
        crud.deleteById(id);
    }
}
