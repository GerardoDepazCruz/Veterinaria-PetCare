package Clinica.veterinaria.PetCare.web.controller.veterinario;

import Clinica.veterinaria.PetCare.domain.dto.HistorialMedicoDTO;
import Clinica.veterinaria.PetCare.domain.dto.MascotaDTO;
import Clinica.veterinaria.PetCare.domain.dto.VacunaDTO;
import Clinica.veterinaria.PetCare.domain.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/veterinario/pacientes")
public class PacientesController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping("/all")
    public List<MascotaDTO> getAllMascotas() {
        return pacienteService.getAllMascotas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MascotaDTO> getMascotaById(@PathVariable int id) {
        Optional<MascotaDTO> mascota = pacienteService.getMascotaById(id);
        return mascota.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Historial Clínico
    @GetMapping("/{idMascota}/historial")
    public ResponseEntity<List<HistorialMedicoDTO>> getHistoriales(@PathVariable int idMascota) {
        List<HistorialMedicoDTO> lista = pacienteService.getHistorialesByMascota(idMascota);
        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204 si no hay historial
        }
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/{idMascota}/historial/add")
    public ResponseEntity<?> addHistorial(@PathVariable int idMascota,
                                          @RequestBody HistorialMedicoDTO historial,
                                          @RequestParam int idVeterinario) {
        historial.setIdMascota(idMascota);
        historial.setIdVeterinario(idVeterinario);
        historial.setFecha(java.time.LocalDate.now());
        HistorialMedicoDTO creado = pacienteService.crearHistorialClinico(historial.getIdMascota(),
                historial.getDescripcion(), historial.getIdVeterinario());
        return ResponseEntity.ok(creado);
    }

    @DeleteMapping("/{idMascota}/historial/delete/{idHistorial}")
    public ResponseEntity<?> deleteHistorial(@PathVariable int idHistorial) {
        pacienteService.deleteHistorial(idHistorial);
        return ResponseEntity.ok().build();
    }

    // Vacunas
    @GetMapping("/{idMascota}/vacunas")
    public ResponseEntity<List<VacunaDTO>> getVacunas(@PathVariable int idMascota) {
        List<VacunaDTO> lista = pacienteService.getVacunasDisponibles(idMascota); // ahora filtramos por mascota
        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/{idMascota}/vacunas/aplicar")
    public ResponseEntity<?> aplicarVacuna(@PathVariable int idMascota,
                                           @RequestBody VacunaDTO vacuna,
                                           @RequestParam int idVeterinario) {
        pacienteService.aplicarVacunaAMascota(idMascota, vacuna, idVeterinario);
        return ResponseEntity.ok("Vacuna aplicada");
    }

    @GetMapping("/{idVeterinario}/mascotas")
    public ResponseEntity<List<MascotaDTO>> getMascotasByVet(@PathVariable int idVeterinario) {
        List<MascotaDTO> lista = pacienteService.getMascotasByVeterinario(idVeterinario);
        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(lista);
    }

}
