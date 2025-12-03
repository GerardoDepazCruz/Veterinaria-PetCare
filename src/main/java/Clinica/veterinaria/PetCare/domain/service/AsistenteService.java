package Clinica.veterinaria.PetCare.domain.service;

import Clinica.veterinaria.PetCare.domain.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AsistenteService {

    @Autowired private UsuarioService usuarioService;
    @Autowired private MascotaService mascotaService;
    @Autowired private CitaService citaService;
    public List<UsuarioDTO> getVeterinarios() { return usuarioService.getUsuariosByRol(1); }  // idRol=1 Veterinario
    public List<MascotaDTO> getMascotas() { return mascotaService.getAllMascotas(); }
    public List<CitaDTO> getCitas() { return citaService.getAllCitas(); }

}
