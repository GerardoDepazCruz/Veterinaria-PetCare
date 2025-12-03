package Clinica.veterinaria.PetCare.persistance.mapper;

import Clinica.veterinaria.PetCare.domain.dto.MascotaDTO;
import Clinica.veterinaria.PetCare.persistance.entity.Mascota;

import java.util.List;
import org.mapstruct.*;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;




@Mapper(componentModel = "spring")
public interface MascotaMapper {

    @Mappings({
        @Mapping(source = "idMascota", target = "id"),
        @Mapping(source = "nombre", target = "nombre"),
        @Mapping(source = "especie", target = "especie"),
        @Mapping(source = "raza", target = "raza"),
        @Mapping(source = "edad", target = "edad"),
        @Mapping(source = "peso", target = "peso"),
        @Mapping(source = "dueno.idUsuario", target = "idDueno"),
        @Mapping(source = "dueno.nombre", target = "nombreDueno")
    })
    MascotaDTO toDTO(Mascota mascota);

    List<MascotaDTO> toDTOList(List<Mascota> mascotas);

    @InheritInverseConfiguration
    @Mapping(target = "citas", ignore = true)
    @Mapping(target = "historiales", ignore = true)
    @Mapping(target = "vacunas", ignore = true)
    Mascota toEntity(MascotaDTO dto);
}