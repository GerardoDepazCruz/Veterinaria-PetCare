package Clinica.veterinaria.PetCare.persistance.mapper;

import Clinica.veterinaria.PetCare.domain.dto.VacunaDTO;
import Clinica.veterinaria.PetCare.persistance.entity.Vacuna;
import org.mapstruct.*;
import java.util.List;

@Mapper(componentModel = "spring")
public interface VacunaMapper {
    @Mappings({
        @Mapping(source = "idVacuna", target = "id"),
        @Mapping(source = "nombre", target = "nombre"),
        @Mapping(source = "descripcion", target = "descripcion")
    })
    VacunaDTO toDTO(Vacuna vacuna);

    List<VacunaDTO> toDTOList(List<Vacuna> vacunas);

    @InheritInverseConfiguration
    @Mapping(target = "aplicaciones", ignore = true)
    Vacuna toEntity(VacunaDTO dto);
}