package com.agendAr.api.agendAr.application.repository.Usuario;

import com.agendAr.api.agendAr.domain.entitys.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
}