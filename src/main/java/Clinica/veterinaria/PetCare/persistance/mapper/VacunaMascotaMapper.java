package Clinica.veterinaria.PetCare.persistance.mapper;

import Clinica.veterinaria.PetCare.domain.dto.VacunaMascotaDTO;
import Clinica.veterinaria.PetCare.persistance.entity.VacunaMascota;
import org.mapstruct.*;
import java.util.List;

@Mapper(componentModel = "spring")
public interface VacunaMascotaMapper {

    @Mappings({
        @Mapping(source = "id.idMascota", target = "idMascota"),
        @Mapping(source = "id.idVacuna", target = "idVacuna"),
        @Mapping(source = "id.idVeterinario", target = "idVeterinario"),
        @Mapping(source = "fecha", target = "fecha"),
        @Mapping(source = "estado", target = "estado")
    })
    VacunaMascotaDTO toDTO(VacunaMascota vacunaMascota);

    List<VacunaMascotaDTO> toDTOList(List<VacunaMascota> lista);

    @InheritInverseConfiguration
    VacunaMascota toEntity(VacunaMascotaDTO dto);
}