package Clinica.veterinaria.PetCare.web.controller.asistente;

import Clinica.veterinaria.PetCare.domain.dto.CitaDTO;
import Clinica.veterinaria.PetCare.domain.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("citas")
public class CitaController {

    @Autowired
    private CitaService citaService;

    @GetMapping("/all")
    public ResponseEntity<List<CitaDTO>> getAll() {
        List<CitaDTO> list = citaService.getAllCitas();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CitaDTO> getById(@PathVariable int id) {
        Optional<CitaDTO> opt = citaService.getCitaById(id);
        return opt.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/veterinario/{idVet}")
    public List<CitaDTO> getByVeterinario(@PathVariable int idVet) {
        return citaService.getCitasByVeterinario(idVet);
    }

    @GetMapping("/mascota/{idMascota}")
    public List<CitaDTO> getByMascota(@PathVariable int idMascota) {
        return citaService.getCitasByMascota(idMascota);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody CitaDTO dto) {
        try {
            CitaDTO saved = citaService.saveCita(dto);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al guardar cita: " + e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody CitaDTO dto) {
        try {
            CitaDTO updated = citaService.updateCita(id, dto);
            return ResponseEntity.ok(updated);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al actualizar cita: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        try {
            citaService.deleteCita(id);
            return ResponseEntity.ok("Cita eliminada correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al eliminar cita: " + e.getMessage());
        }
    }

    @GetMapping("/search")
    public List<CitaDTO> search(@RequestParam String keyword) {
        return citaService.searchCitas(keyword);
    }
}
