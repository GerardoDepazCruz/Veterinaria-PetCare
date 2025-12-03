package Clinica.veterinaria.PetCare.web.controller.usuario;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginUsuarioController {

    @GetMapping("/login")
    public String loginUsuario() {
        return "usuario/login"; // login normal para usuarios
    }
}
