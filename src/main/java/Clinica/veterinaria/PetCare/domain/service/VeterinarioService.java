package Clinica.veterinaria.PetCare.domain.service;

import Clinica.veterinaria.PetCare.domain.dto.UsuarioDTO;
import Clinica.veterinaria.PetCare.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeterinarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<UsuarioDTO> getAllVeterinarios() {
        return usuarioRepository.getByRol(1);
    }

    public Optional<UsuarioDTO> getVeterinarioById(int id) {
        Optional<UsuarioDTO> opt = usuarioRepository.getById(id);
        if (opt.isPresent() && opt.get().getIdRol() == 1) {
            limpiarPassword(opt.get());
            return opt;
        }
        return Optional.empty();
    }

    public UsuarioDTO updateVeterinario(int id, UsuarioDTO dto) {
        Optional<UsuarioDTO> opt = usuarioRepository.getById(id);
        if (opt.isEmpty() || opt.get().getIdRol() != 1) {
            throw new RuntimeException("Veterinario no encontrado");
        }

        UsuarioDTO existing = opt.get();

        existing.setNombre(dto.getNombre());
        existing.setApellido(dto.getApellido());
        existing.setCorreo(dto.getCorreo());
        existing.setTelefono(dto.getTelefono());

        String newPass = dto.getPassword();

        if (newPass == null || newPass.isEmpty()) {
            String passwordBD = usuarioRepository.getPasswordById(id);
            if (passwordBD == null || passwordBD.isEmpty()) {
                throw new RuntimeException("No se encontró contraseña en la base de datos");
            }
            newPass = passwordBD;
        } else if (!newPass.startsWith("$2a$")) {
            newPass = passwordEncoder.encode(newPass);
        }
        existing.setPassword(newPass);

        return usuarioRepository.save(existing);
    }

    public void deleteVeterinario(int id) {
        Optional<UsuarioDTO> opt = usuarioRepository.getById(id);
        if (opt.isPresent() && opt.get().getIdRol() == 1) {
            usuarioRepository.delete(id);
        } else {
            throw new RuntimeException("Veterinario no encontrado");
        }
    }

    public List<UsuarioDTO> searchVeterinarios(String keyword) {
        String kwLower = keyword.toLowerCase();
        return getAllVeterinarios().stream()
                .filter(v -> (v.getNombre() != null && v.getNombre().toLowerCase().contains(kwLower)) ||
                        (v.getApellido() != null && v.getApellido().toLowerCase().contains(kwLower)))
                .toList();
    }

    private void limpiarPassword(UsuarioDTO dto) {
        if (dto != null) {
            dto.setPassword(null);
        }
    }
}
