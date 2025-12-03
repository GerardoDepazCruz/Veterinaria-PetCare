package Clinica.veterinaria.PetCare.domain.repository;

import Clinica.veterinaria.PetCare.domain.dto.UsuarioDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository {
    List<UsuarioDTO> getAll();
    Optional<UsuarioDTO> getById(int id);
    List<UsuarioDTO> getByRol(int idRol);
    UsuarioDTO save(UsuarioDTO usuario);
    void delete(int id);
    @Query("SELECT u.password FROM Usuario u WHERE u.id = :id")
    String getPasswordById(@Param("id") int id);
}