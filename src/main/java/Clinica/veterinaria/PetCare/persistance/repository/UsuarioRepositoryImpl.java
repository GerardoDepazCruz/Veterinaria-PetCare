package Clinica.veterinaria.PetCare.persistance.repository;

import Clinica.veterinaria.PetCare.domain.dto.UsuarioDTO;
import Clinica.veterinaria.PetCare.domain.repository.UsuarioRepository;
import Clinica.veterinaria.PetCare.persistance.crud.UsuarioCrudRepository;
import Clinica.veterinaria.PetCare.persistance.entity.Usuario;
import Clinica.veterinaria.PetCare.persistance.mapper.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {

    @Autowired
    private UsuarioCrudRepository crud;

    @Autowired
    private UsuarioMapper mapper;

    @Override
    public List<UsuarioDTO> getAll() {
        return mapper.toDTOList((List<Usuario>) crud.findAll());
    }

    @Override
    public Optional<UsuarioDTO> getById(int id) {
        return crud.findById(id).map(mapper::toDTO);
    }

    @Override
    public List<UsuarioDTO> getByRol(int idRol) {
        return mapper.toDTOList(crud.findByRolIdRol(idRol));
    }

    @Override
    public UsuarioDTO save(UsuarioDTO usuario) {
        Usuario entity = mapper.toEntity(usuario);

        // 🔒 Asegurarse de no sobreescribir password con null
        if (entity.getPassword() == null || entity.getPassword().isEmpty()) {
            crud.findById(entity.getIdUsuario()).ifPresent(u -> entity.setPassword(u.getPassword()));
        }

        return mapper.toDTO(crud.save(entity));
    }

    @Override
    public void delete(int id) {
        crud.deleteById(id);
    }

    @Override
    public String getPasswordById(int id) {
        return crud.findPasswordById(id);
    }
}
