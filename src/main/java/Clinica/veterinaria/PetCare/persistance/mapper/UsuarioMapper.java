package Clinica.veterinaria.PetCare.persistance.mapper;

import Clinica.veterinaria.PetCare.domain.dto.UsuarioDTO;
import Clinica.veterinaria.PetCare.persistance.entity.Usuario;
import org.mapstruct.*;
import java.util.List;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    @Mappings({
        @Mapping(source = "idUsuario", target = "id"),
        @Mapping(source = "nombre", target = "nombre"),
        @Mapping(source = "apellido", target = "apellido"),
        @Mapping(source = "correo", target = "correo"),
        @Mapping(source = "telefono", target = "telefono"),
        @Mapping(source = "rol.idRol", target = "idRol"),
        @Mapping(source = "rol.nombre", target = "nombreRol"),
        @Mapping(target = "password", ignore = true)
    })
    UsuarioDTO toDTO(Usuario usuario);

    List<UsuarioDTO> toDTOList(List<Usuario> usuarios);

    @InheritInverseConfiguration
    @Mapping(target = "mascotas", ignore = true)
    @Mapping(target = "citas", ignore = true)
    @Mapping(target = "historiales", ignore = true)
    @Mapping(target = "vacunasAplicadas", ignore = true)
    Usuario toEntity(UsuarioDTO dto);
}
