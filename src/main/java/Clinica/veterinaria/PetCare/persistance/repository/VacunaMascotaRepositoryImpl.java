package Clinica.veterinaria.PetCare.persistance.repository;

import Clinica.veterinaria.PetCare.domain.dto.VacunaMascotaDTO;
import Clinica.veterinaria.PetCare.domain.repository.VacunaMascotaRepository;
import Clinica.veterinaria.PetCare.persistance.crud.VacunaMascotaCrudRepository;
import Clinica.veterinaria.PetCare.persistance.entity.VacunaMascota;
import Clinica.veterinaria.PetCare.persistance.mapper.VacunaMascotaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VacunaMascotaRepositoryImpl implements VacunaMascotaRepository {

    @Autowired
    private VacunaMascotaCrudRepository crud;

    @Autowired
    private VacunaMascotaMapper mapper;

    @Override
    public List<VacunaMascotaDTO> getAll() {
        return mapper.toDTOList((List<VacunaMascota>) crud.findAll());
    }

    @Override
    public List<VacunaMascotaDTO> getByMascota(int idMascota) {
        return mapper.toDTOList(crud.findByMascotaIdMascota(idMascota));
    }

    @Override
    public List<VacunaMascotaDTO> getByVeterinario(int idVet) {
        return mapper.toDTOList(crud.findByVeterinarioIdUsuario(idVet));
    }

    @Override
    public VacunaMascotaDTO save(VacunaMascotaDTO dto) {
        VacunaMascota entity = mapper.toEntity(dto);
        return mapper.toDTO(crud.save(entity));
    }
}
