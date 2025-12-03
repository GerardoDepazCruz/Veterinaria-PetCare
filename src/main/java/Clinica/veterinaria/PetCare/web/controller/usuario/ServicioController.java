package Clinica.veterinaria.PetCare.web.controller.usuario;

import Clinica.veterinaria.PetCare.domain.dto.ServicioDTO;
import Clinica.veterinaria.PetCare.domain.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/servicios")
public class ServicioController {

    @Autowired
    private ServicioRepository servicioRepository;

    // Listar todos los servicios
    @GetMapping("/all")
    public ResponseEntity<List<ServicioDTO>> getAll() {
        List<ServicioDTO> list = servicioRepository.getAll();
        return ResponseEntity.ok(list);
    }


    // Obtener un servicio por ID
    @GetMapping("/{id}")
    public ResponseEntity<ServicioDTO> getById(@PathVariable("id") int idServicio) {
        Optional<ServicioDTO> opt = servicioRepository.getById(idServicio);
        return opt.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }


    // Obtener servicios filtrando por especie
    @GetMapping("/especie/{especie}")
    public ResponseEntity<List<ServicioDTO>> getByEspecie(@PathVariable("especie") String especie) {
        List<ServicioDTO> list = servicioRepository.getByEspecieDestino(especie);
        return ResponseEntity.ok(list);
    }


    // Guardar un nuevo servicio o actualizar uno existente
    @PostMapping("/save")
    public ResponseEntity<ServicioDTO> save(@RequestBody ServicioDTO servicio) {
        ServicioDTO saved = servicioRepository.save(servicio);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }


    // Eliminar un servicio por ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        servicioRepository.delete(id);
        return ResponseEntity.noContent().build();
    }

}