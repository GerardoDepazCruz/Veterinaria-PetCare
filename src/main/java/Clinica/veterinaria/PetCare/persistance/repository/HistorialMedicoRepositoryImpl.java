package Clinica.veterinaria.PetCare.persistance.repository;

import Clinica.veterinaria.PetCare.domain.dto.HistorialMedicoDTO;
import Clinica.veterinaria.PetCare.domain.repository.HistorialMedicoRepository;
import Clinica.veterinaria.PetCare.persistance.crud.HistorialMedicoCrudRepository;
import Clinica.veterinaria.PetCare.persistance.entity.HistorialMedico;
import Clinica.veterinaria.PetCare.persistance.mapper.HistorialMedicoMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class HistorialMedicoRepositoryImpl implements HistorialMedicoRepository {

    @Autowired
    private HistorialMedicoCrudRepository crud;

    @Autowired
    private HistorialMedicoMapper mapper;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<HistorialMedicoDTO> getAll() {
        return mapper.toDTOList((List<HistorialMedico>) crud.findAll());
    }

    @Override
    public Optional<HistorialMedicoDTO> getById(int id) {
        return crud.findById(id).map(mapper::toDTO);
    }

    @Override
    public List<HistorialMedicoDTO> getByMascota(int idMascota) {
        return mapper.toDTOList(crud.findByMascotaIdMascota(idMascota));
    }

    @Override
    public List<HistorialMedicoDTO> getByVeterinario(int idVet) {
        return mapper.toDTOList(crud.findByVeterinarioIdUsuario(idVet));
    }

    @Override
    public HistorialMedicoDTO save(HistorialMedicoDTO historial) {
        HistorialMedico entity = mapper.toEntity(historial);
        return mapper.toDTO(crud.save(entity));
    }

    @Override
    public void delete(int id) {
        crud.deleteById(id);
    }

    @Override
    public List<HistorialMedicoDTO> searchByVeterinarioAndNombreMascota(int idVet, String nombreMascota) {
        String queryStr = "SELECT new Clinica.veterinaria.PetCare.domain.dto.HistorialMedicoDTO(" +
                "h.idHistorial, " +
                "v.nombre, " +
                "v.idUsuario, " +
                "m.nombre, " +
                "m.idMascota, " +
                "h.fecha, " +
                "h.descripcion) " +
                "FROM HistorialMedico h " +
                "JOIN h.mascota m " +
                "JOIN h.veterinario v " +
                "WHERE v.idUsuario = :idVet AND LOWER(m.nombre) LIKE :nombreMascota";

        TypedQuery<HistorialMedicoDTO> query = entityManager.createQuery(queryStr, HistorialMedicoDTO.class);
        query.setParameter("idVet", idVet);
        query.setParameter("nombreMascota", "%" + nombreMascota.toLowerCase() + "%");

        return query.getResultList();
    }

    // 🔹 Implementaciones de los nuevos métodos

    @Override
    public List<HistorialMedicoDTO> findByIdMascota(int idMascota) {
        return getByMascota(idMascota); // Reutilizamos método ya existente
    }

    @Override
    public void deleteById(int idHistorial) {
        delete(idHistorial); // Reutilizamos método ya existente
    }

    @Override
    public String getDescripcion(int idHistorial) {
        Optional<HistorialMedicoDTO> historial = getById(idHistorial);
        return historial.map(HistorialMedicoDTO::getDescripcion).orElse(null);
    }
}
