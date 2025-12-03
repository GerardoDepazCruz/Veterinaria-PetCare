package Clinica.veterinaria.PetCare.web.controller.usuario;

import Clinica.veterinaria.PetCare.domain.dto.MascotaDTO;
import Clinica.veterinaria.PetCare.domain.service.MascotaClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente/mascotas")
public class MascotaClienteController {

    @Autowired
    private MascotaClienteService mascotaClienteService;

    // Listar mascotas por usuario
    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<MascotaDTO>> getMascotasByUsuario(@PathVariable int idUsuario) {
        List<MascotaDTO> list = mascotaClienteService.getMascotasByUsuario(idUsuario);
        return ResponseEntity.ok(list);
    }

    // Obtener mascota por ID
    @GetMapping("/{id}")
    public ResponseEntity<MascotaDTO> getMascotaById(@PathVariable int id) {
        Optional<MascotaDTO> mascota = mascotaClienteService.getMascotaById(id);
        return mascota.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Guardar o actualizar mascota
    @PostMapping("/save")
    public ResponseEntity<MascotaDTO> saveMascota(@RequestBody MascotaDTO mascota) {
        MascotaDTO guardada = mascotaClienteService.saveMascota(mascota);
        return ResponseEntity.ok(guardada);
    }

    // Eliminar mascota por ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMascota(@PathVariable int id) {
        mascotaClienteService.deleteMascota(id);
        return ResponseEntity.ok().build();
    }
}
