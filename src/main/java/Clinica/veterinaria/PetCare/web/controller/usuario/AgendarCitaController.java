package Clinica.veterinaria.PetCare.web.controller.usuario;

import Clinica.veterinaria.PetCare.domain.dto.CitaDTO;
import Clinica.veterinaria.PetCare.domain.service.AgendarCitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente/citas")
public class AgendarCitaController {

    @Autowired
    private AgendarCitaService agendarCitaService;

    @PostMapping("/agendar")
    public ResponseEntity<String> agendarCita(@RequestBody CitaDTO citaDTO) {
        agendarCitaService.agendarCita(citaDTO);
        return ResponseEntity.ok("Cita agendada con éxito");
    }
}