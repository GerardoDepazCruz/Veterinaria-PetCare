package Clinica.veterinaria.PetCare.persistance.mapper;

import Clinica.veterinaria.PetCare.domain.dto.HistorialMedicoDTO;
import Clinica.veterinaria.PetCare.persistance.entity.HistorialMedico;
import org.mapstruct.*;
import java.util.List;

@Mapper(componentModel = "spring")
public interface HistorialMedicoMapper {

    @Mappings({
        @Mapping(source = "idHistorial", target = "id"),
        @Mapping(source = "descripcion", target = "descripcion"),
        @Mapping(source = "fecha", target = "fecha"),
        @Mapping(source = "mascota.idMascota", target = "idMascota"),
        @Mapping(source = "mascota.nombre", target = "nombreMascota"),
        @Mapping(source = "veterinario.idUsuario", target = "idVeterinario"),
        @Mapping(source = "veterinario.nombre", target = "nombreVeterinario")
    })
    HistorialMedicoDTO toDTO(HistorialMedico historial);

    List<HistorialMedicoDTO> toDTOList(List<HistorialMedico> historiales);

    @InheritInverseConfiguration
    HistorialMedico toEntity(HistorialMedicoDTO dto);
}
