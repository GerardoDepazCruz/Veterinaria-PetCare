package Clinica.veterinaria.PetCare.web.controller.usuario;


import Clinica.veterinaria.PetCare.domain.dto.VacunaMascotaDTO;
import Clinica.veterinaria.PetCare.domain.repository.VacunaMascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuario/vacunas-mascota")
public class VacunaMascotaControllerUsuario {

    @Autowired
    private VacunaMascotaRepository vacunaMascotaRepository;

    // Obtener todas las vacunas aplicadas
    @GetMapping("/all")
    public ResponseEntity<List<VacunaMascotaDTO>> getAll() {
        List<VacunaMascotaDTO> list = vacunaMascotaRepository.getAll();
        return ResponseEntity.ok(list);
    }

    // Obtener vacunas por mascota
    @GetMapping("/mascota/{idMascota}")
    public ResponseEntity<List<VacunaMascotaDTO>> getByMascota(@PathVariable int idMascota) {
        List<VacunaMascotaDTO> list = vacunaMascotaRepository.getByMascota(idMascota);
        return ResponseEntity.ok(list);
    }


    // Obtener vacunas por veterinario
    @GetMapping("/veterinario/{idVet}")
    public ResponseEntity<List<VacunaMascotaDTO>> getByVeterinario(@PathVariable int idVet) {
        List<VacunaMascotaDTO> list = vacunaMascotaRepository.getByVeterinario(idVet);
        return ResponseEntity.ok(list);
    }


    // Registrar una vacuna aplicada
    @PostMapping("/save")
    public ResponseEntity<VacunaMascotaDTO> save(@RequestBody VacunaMascotaDTO dto) {
        VacunaMascotaDTO saved = vacunaMascotaRepository.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

}