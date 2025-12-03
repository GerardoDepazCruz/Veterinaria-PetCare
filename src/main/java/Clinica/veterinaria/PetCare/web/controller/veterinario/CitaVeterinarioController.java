package Clinica.veterinaria.PetCare.web.controller.veterinario;

import Clinica.veterinaria.PetCare.domain.dto.CitaDTO;
import Clinica.veterinaria.PetCare.domain.service.CitaVeterinarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veterinario/citas")
public class CitaVeterinarioController {

    @Autowired
    private CitaVeterinarioService citaVeterinarioService;

    @GetMapping("/{idVet}")
    public ResponseEntity<List<CitaDTO>> getCitasByVeterinario(@PathVariable int idVet) {
        List<CitaDTO> citas = citaVeterinarioService.getCitasByVeterinario(idVet);
        if (citas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(citas);
    }
}
