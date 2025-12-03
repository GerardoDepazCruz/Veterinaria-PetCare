package Clinica.veterinaria.PetCare.web.controller.asistente;

import Clinica.veterinaria.PetCare.domain.dto.MascotaDTO;
import Clinica.veterinaria.PetCare.domain.service.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mascotas")
public class MascotaController {

    @Autowired
    private MascotaService mascotaService;

     @GetMapping("/all")
    public ResponseEntity<List<MascotaDTO>> getAll() {
        List<MascotaDTO> list = mascotaService.getAllMascotas();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MascotaDTO> getById(@PathVariable("id") int idMascota) {
        Optional<MascotaDTO> mascota = mascotaService.getMascotaById(idMascota);
        return mascota.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody MascotaDTO mascota) {
        try {
            MascotaDTO saved = mascotaService.saveMascota(mascota);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al agregar mascota: " + e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody MascotaDTO mascota) {
        try {
            MascotaDTO updated = mascotaService.updateMascota(id, mascota);
            return ResponseEntity.ok(updated);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al actualizar mascota: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        try {
            mascotaService.deleteMascota(id);
            return ResponseEntity.ok("Mascota eliminada correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al eliminar mascota: " + e.getMessage());
        }
    }
}
