package Clinica.veterinaria.PetCare.web.controller.rest;

import Clinica.veterinaria.PetCare.domain.security.JwtProvider;
import Clinica.veterinaria.PetCare.persistance.crud.UsuarioCrudRepository;
import Clinica.veterinaria.PetCare.persistance.entity.Rol;
import Clinica.veterinaria.PetCare.persistance.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth/veterinario")
public class AuthVeterinarioController {

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private UsuarioCrudRepository usuarioCrudRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> loginData) {
        String correo = loginData.get("correo");
        String password = loginData.get("password");
        Map<String, Object> response = new HashMap<>();

        if (correo == null || password == null) {
            response.put("error", "Debe enviar correo y contraseña");
            return ResponseEntity.badRequest().body(response);
        }

        Usuario usuario = usuarioCrudRepository.findByCorreo(correo).orElse(null);

        if (usuario == null || !passwordEncoder.matches(password, usuario.getPassword())) {
            response.put("error", "Credenciales inválidas");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

        // Validar que sea veterinario
        if (!"Veterinario".equalsIgnoreCase(usuario.getRol().getNombre())) {
            response.put("error", "Acceso denegado: no pertenece al rol Veterinario");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        }

        String token = jwtProvider.generarToken(usuario.getCorreo(), usuario.getRol().getNombre());
        response.put("token", token);
        response.put("role", usuario.getRol().getNombre());
        response.put("userId", usuario.getIdUsuario());
        response.put("message", "Login exitoso");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> register(@RequestBody Map<String, Object> registerData) {
        String correo = (String) registerData.get("correo");
        String password = (String) registerData.get("password");
        String nombre = (String) registerData.get("nombre");
        String apellido = (String) registerData.get("apellido");
        String telefono = (String) registerData.get("telefono");

        Map<String, Object> response = new HashMap<>();

        if (correo == null || password == null || nombre == null || apellido == null || telefono == null) {
            response.put("error", "Debe enviar todos los campos requeridos");
            return ResponseEntity.badRequest().body(response);
        }

        if (usuarioCrudRepository.findByCorreo(correo).isPresent()) {
            response.put("error", "El correo ya está registrado");
            return ResponseEntity.badRequest().body(response);
        }

        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setCorreo(correo);
        nuevoUsuario.setPassword(passwordEncoder.encode(password));
        nuevoUsuario.setNombre(nombre);
        nuevoUsuario.setApellido(apellido);
        nuevoUsuario.setTelefono(telefono);

        Rol rol = new Rol();
        rol.setIdRol(1);
        rol.setNombre("Veterinario");
        nuevoUsuario.setRol(rol);

        usuarioCrudRepository.save(nuevoUsuario);
        response.put("message", "Registro exitoso");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
