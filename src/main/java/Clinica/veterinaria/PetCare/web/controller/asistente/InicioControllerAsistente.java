package Clinica.veterinaria.PetCare.web.controller.asistente;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioControllerAsistente {

    @GetMapping("/asistente/inicio")
    public String iniciodAsistente() {
        return "asistente/inicio";
    }
}
