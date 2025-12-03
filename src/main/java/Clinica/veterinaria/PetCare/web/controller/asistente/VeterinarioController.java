package Clinica.veterinaria.PetCare.web.controller.asistente;

import Clinica.veterinaria.PetCare.domain.dto.UsuarioDTO;
import Clinica.veterinaria.PetCare.domain.service.VeterinarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("veterinarios")
public class VeterinarioController {

    @Autowired
    private VeterinarioService veterinarioService;

    @GetMapping("/all")
    public ResponseEntity<List<UsuarioDTO>> getAll() {
        List<UsuarioDTO> list = veterinarioService.getAllVeterinarios();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> getById(@PathVariable int id) {
        Optional<UsuarioDTO> opt = veterinarioService.getVeterinarioById(id);
        return opt.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody UsuarioDTO dto) {
        try {
            UsuarioDTO updated = veterinarioService.updateVeterinario(id, dto);
            return ResponseEntity.ok(updated);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al actualizar veterinario: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        try {
            veterinarioService.deleteVeterinario(id);
            return ResponseEntity.ok("Veterinario eliminado correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al eliminar veterinario: " + e.getMessage());
        }
    }

     @GetMapping("/search")
    public ResponseEntity<List<UsuarioDTO>> search(@RequestParam String keyword) {
        List<UsuarioDTO> list = veterinarioService.searchVeterinarios(keyword);
        return ResponseEntity.ok(list);
    }
    
}
