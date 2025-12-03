package Clinica.veterinaria.PetCare.web.controller.veterinario;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginVeterinarioController {

    @GetMapping("/login/veterinario")
    public String loginVeterinario() {
        return "veterinario/login-veterinario";
    }

}
