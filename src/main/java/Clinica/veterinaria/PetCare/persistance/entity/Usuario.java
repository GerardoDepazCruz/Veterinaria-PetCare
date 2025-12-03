package Clinica.veterinaria.PetCare.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String apellido;

    @Column(nullable = false, unique = true, length = 100)
    private String correo;

    @Column(length = 20)
    private String telefono;

    @Column(nullable = false, length = 255)
    private String password;

    // Relación con Rol
    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Rol rol;

    // Relación con Mascota (Dueño)
    @OneToMany(mappedBy = "dueno")
    private List<Mascota> mascotas;

    // Relación con Citas como veterinario
    @OneToMany(mappedBy = "veterinario")
    private List<Cita> citas;

    // Relación con Historial Médico como veterinario
    @OneToMany(mappedBy = "veterinario")
    private List<HistorialMedico> historiales;

    // Relación con vacunas aplicadas como veterinario
    @OneToMany(mappedBy = "veterinario")
    private List<VacunaMascota> vacunasAplicadas;

}
