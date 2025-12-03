package Clinica.veterinaria.PetCare.persistance.mapper;
import Clinica.veterinaria.PetCare.domain.dto.ServicioDTO;
import Clinica.veterinaria.PetCare.persistance.entity.Servicio;
import org.mapstruct.*;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ServicioMapper {
    @Mappings({
        @Mapping(source = "idServicio", target = "id"),
        @Mapping(source = "nombre", target = "nombre"),
        @Mapping(source = "descripcion", target = "descripcion"),
        @Mapping(source = "precio", target = "precio"),
        @Mapping(source = "especieDestino", target = "especieDestino")
    })
    ServicioDTO toDTO(Servicio servicio);

    List<ServicioDTO> toDTOList(List<Servicio> servicios);

    @InheritInverseConfiguration
    @Mapping(target = "citas", ignore = true)
    Servicio toEntity(ServicioDTO dto);
}
