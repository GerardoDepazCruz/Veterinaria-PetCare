package Clinica.veterinaria.PetCare.persistance.repository;

import Clinica.veterinaria.PetCare.domain.dto.MascotaDTO;
import Clinica.veterinaria.PetCare.domain.repository.MascotaRepository;
import Clinica.veterinaria.PetCare.persistance.crud.MascotaCrudRepository;
import Clinica.veterinaria.PetCare.persistance.entity.Mascota;
import Clinica.veterinaria.PetCare.persistance.mapper.MascotaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class MascotaRepositoryImpl implements MascotaRepository {

    @Autowired
    private MascotaCrudRepository crud;

    @Autowired
    private MascotaMapper mapper;

    @Override
    public List<MascotaDTO> getAll() {
        return mapper.toDTOList((List<Mascota>) crud.findAll());
    }

    @Override
    public List<MascotaDTO> getByVeterinario(int idVeterinario) {
        return mapper.toDTOList(crud.findMascotasByVeterinario(idVeterinario));
    }

    @Override
    public Optional<MascotaDTO> getById(int id) {
        return crud.findById(id).map(mapper::toDTO);
    }

    @Override
    public List<MascotaDTO> getByDueno(int idDueno) {
        return mapper.toDTOList(crud.findByDuenoIdUsuario(idDueno));
    }

    @Override
    public MascotaDTO save(MascotaDTO mascota) {
        Mascota entity = mapper.toEntity(mascota);
        return mapper.toDTO(crud.save(entity));
    }

    @Override
    public void delete(int id) {
        crud.deleteById(id);
    }
}
