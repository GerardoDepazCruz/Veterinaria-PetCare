package Clinica.veterinaria.PetCare.web.controller.asistente;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginAsistenteController {

    @GetMapping("/login/asistente")
    public String loginAsistente() {
        return "asistente/login-asistente";
    }
}
