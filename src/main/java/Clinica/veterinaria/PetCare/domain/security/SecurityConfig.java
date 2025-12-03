package Clinica.veterinaria.PetCare.domain.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
public class SecurityConfig {

    private final UsuarioDetailsServiceImpl usuarioDetailsService;
    private final JwtAuthenticationFilter jwtAuthFilter;

    public SecurityConfig(UsuarioDetailsServiceImpl usuarioDetailsService,
                          JwtAuthenticationFilter jwtAuthFilter) {
        this.usuarioDetailsService = usuarioDetailsService;
        this.jwtAuthFilter = jwtAuthFilter;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(usuarioDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/auth/**").permitAll()
                        .requestMatchers("/api/auth/veterinario/**").permitAll()
                        .requestMatchers("/api/auth/cliente/**").permitAll()

                        .requestMatchers("/d/w/mascotas/**").hasRole("Asistente")
                        .requestMatchers("/d/w/veterinarios/**").hasRole("Asistente")
                        .requestMatchers("/d/w/citas/**").hasRole("Asistente")

                        .requestMatchers("/d/w/veterinario/citas/**").hasRole("Veterinario")
                        .requestMatchers("/d/w/veterinario/historial/**").hasRole("Veterinario")
                        .requestMatchers("/d/w/veterinario/pacientes/**").hasRole("Veterinario")
                        .requestMatchers("/d/w/vacunas/**").hasRole("Veterinario")
                        .requestMatchers("/d/w/vacunas-mascota/**").hasRole("Veterinario")

                        .requestMatchers("/d/w/cliente/mascotas/**").hasRole("Cliente")
                        .requestMatchers("/d/w/servicios/**").hasRole("Cliente")
                        .requestMatchers("/d/w/cliente/citas/**").hasRole("Cliente")

                        .requestMatchers("/admin/**").hasRole("Veterinario")
                        .requestMatchers("/user/**").hasAnyRole("Cliente", "Asistente", "Veterinario")
                        .anyRequest().authenticated()
                )
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(List.of("http://localhost:3000"));
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        config.setAllowedHeaders(List.of("Authorization", "Content-Type"));
        config.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }
}
