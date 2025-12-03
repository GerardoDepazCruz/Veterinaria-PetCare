package Clinica.veterinaria.PetCare.web.controller.veterinario;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioControllerVeterinario {

    @GetMapping("/veterinario/inicio")
    public String iniciodVeterinario() {
        return "veterinario/inicio";
    }
}
