package Clinica.veterinaria.PetCare.web.controller.veterinario;

import Clinica.veterinaria.PetCare.domain.dto.HistorialMedicoDTO;
import Clinica.veterinaria.PetCare.domain.service.HistorialMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/veterinario/historial")
public class HistorialMedicoController {

    @Autowired
    private HistorialMedicoService service;

    @GetMapping("/all/{idVet}")
    public ResponseEntity<List<HistorialMedicoDTO>> getAll(@PathVariable int idVet) {
        List<HistorialMedicoDTO> list = service.getHistorialesByVeterinario(idVet);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistorialMedicoDTO> getById(@PathVariable("id") int id) {
        Optional<HistorialMedicoDTO> opt = service.getHistorialById(id);
        return opt.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search/{idVet}")
    public ResponseEntity<List<HistorialMedicoDTO>> searchByNombreMascota(
            @PathVariable int idVet,
            @RequestParam String nombreMascota) {

        List<HistorialMedicoDTO> resultados = service.searchByVeterinarioAndNombreMascota(idVet, nombreMascota);
        if(resultados.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(resultados);
    }

    @PostMapping("/save")
    public HistorialMedicoDTO save(@RequestBody HistorialMedicoDTO historial) {
        return service.saveHistorial(historial);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id) {
        service.deleteHistorial(id);
    }
}
