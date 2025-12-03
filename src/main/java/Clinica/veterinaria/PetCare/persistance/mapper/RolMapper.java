package Clinica.veterinaria.PetCare.persistance.mapper;

import Clinica.veterinaria.PetCare.domain.dto.RolDTO;
import Clinica.veterinaria.PetCare.persistance.entity.Rol;
import org.mapstruct.*;
import java.util.List;

@Mapper(componentModel = "spring")
public interface RolMapper {

    @Mappings({
        @Mapping(source = "idRol", target = "id"),
        @Mapping(source = "nombre", target = "nombre")
    })
    RolDTO toDTO(Rol rol);

    List<RolDTO> toDTOList(List<Rol> roles);

    @InheritInverseConfiguration
    @Mapping(target = "usuarios", ignore = true)
    Rol toEntity(RolDTO dto);
}