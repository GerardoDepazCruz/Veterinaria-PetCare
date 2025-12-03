package Clinica.veterinaria.PetCare.persistance.mapper;

import Clinica.veterinaria.PetCare.domain.dto.CitaDTO;
import Clinica.veterinaria.PetCare.persistance.entity.Cita;
import org.mapstruct.*;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CitaMapper {
    @Mappings({
        @Mapping(source = "idCita", target = "id"),
        @Mapping(source = "fecha", target = "fecha"),
        @Mapping(source = "hora", target = "hora"),
        @Mapping(source = "estado", target = "estado"),
        @Mapping(source = "mascota.idMascota", target = "idMascota"),
        @Mapping(source = "mascota.nombre", target = "nombreMascota"),
        @Mapping(source = "servicio.idServicio", target = "idServicio"),
        @Mapping(source = "servicio.nombre", target = "nombreServicio"),
        @Mapping(source = "veterinario.idUsuario", target = "idVeterinario"),
        @Mapping(source = "veterinario.nombre", target = "nombreVeterinario")
    })
    CitaDTO toDTO(Cita cita);

    List<CitaDTO> toDTOList(List<Cita> citas);

    @InheritInverseConfiguration
    Cita toEntity(CitaDTO dto);
}