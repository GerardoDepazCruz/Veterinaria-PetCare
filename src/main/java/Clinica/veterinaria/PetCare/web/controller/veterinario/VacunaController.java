package Clinica.veterinaria.PetCare.web.controller.veterinario;

import Clinica.veterinaria.PetCare.domain.dto.VacunaDTO;
import Clinica.veterinaria.PetCare.domain.repository.VacunaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vacunas")
public class VacunaController {

    @Autowired
    private VacunaRepository vacunaRepository;

    // Obtener todas las vacunas
    @GetMapping("/all")
    public ResponseEntity<List<VacunaDTO>> getAll() {
        List<VacunaDTO> list = vacunaRepository.getAll();
        return ResponseEntity.ok(list);
    }


    // Obtener vacuna por ID
    @GetMapping("/{id}")
    public ResponseEntity<VacunaDTO> getById(@PathVariable("id") int id) {
        Optional<VacunaDTO> opt = vacunaRepository.getById(id);
        return opt.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }


    // Crear o actualizar vacuna
    @PostMapping("/save")
    public ResponseEntity<VacunaDTO> save(@RequestBody VacunaDTO vacuna) {
        VacunaDTO saved = vacunaRepository.save(vacuna);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }


    // Eliminar vacuna por ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        vacunaRepository.delete(id);
        return ResponseEntity.noContent().build();
    }

}