package Clinica.veterinaria.PetCare.persistance.crud;

import Clinica.veterinaria.PetCare.persistance.entity.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UsuarioCrudRepository extends CrudRepository<Usuario, Integer> {
    List<Usuario> findByRolIdRol(Integer idRol);
    Optional<Usuario> findByCorreo(String correo);
    @Query("SELECT u.password FROM Usuario u WHERE u.idUsuario = :id")
    String findPasswordById(@Param("id") int id);
}