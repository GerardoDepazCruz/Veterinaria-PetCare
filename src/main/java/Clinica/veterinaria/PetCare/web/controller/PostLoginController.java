package Clinica.veterinaria.PetCare.web.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostLoginController {

    @GetMapping("/postLoginRedirect")
    public String redirectAfterLogin(Authentication authentication) {
        if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_Veterinario"))) {
            return "redirect:/veterinario/inicio";
        } else if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_Asistente"))) {
            return "redirect:/asistente/inicio";
        } else if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_Cliente"))) {
            return "redirect:/usuario/inicio";
        }
        return "redirect:/login?error"; // Si no reconoce el rol, redirige con error
    }
}
