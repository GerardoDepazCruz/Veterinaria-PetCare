package Clinica.veterinaria.PetCare.domain.service;

import Clinica.veterinaria.PetCare.domain.dto.UsuarioDTO;
import Clinica.veterinaria.PetCare.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public List<UsuarioDTO> getAllUsuarios() {
        List<UsuarioDTO> usuarios = usuarioRepository.getAll();
        usuarios.forEach(this::limpiarPassword);
        return usuarios;
    }
    public Optional<UsuarioDTO> getUsuarioById(int id) {
        Optional<UsuarioDTO> opt = usuarioRepository.getById(id);
        opt.ifPresent(this::limpiarPassword);
        return opt;
    }

    public List<UsuarioDTO> getUsuariosByRol(int idRol) {
        List<UsuarioDTO> usuarios = usuarioRepository.getByRol(idRol);
        usuarios.forEach(this::limpiarPassword);
        return usuarios;
    }
    public UsuarioDTO saveUsuario(UsuarioDTO usuario) {
        if (usuario.getCorreo() == null || usuario.getNombre() == null) {
            throw new IllegalArgumentException("Campos requeridos faltantes");
        }
        if (usuario.getPassword() != null && !usuario.getPassword().startsWith("$2a$")) {
            usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        }
        UsuarioDTO saved = usuarioRepository.save(usuario);
        limpiarPassword(saved);
        return saved;
    }
    public void deleteUsuario(int id) {
        if (!usuarioRepository.getById(id).isPresent()) {
            throw new IllegalArgumentException("Usuario no encontrado");
        }
        usuarioRepository.delete(id);
    }
    private void limpiarPassword(UsuarioDTO dto) {
        if (dto != null) dto.setPassword(null);
    }
}
