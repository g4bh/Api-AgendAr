package com.agendAr.api.agendAr.application.repository.Visita;

import com.agendAr.api.agendAr.domain.entitys.Usuario;
import com.agendAr.api.agendAr.domain.entitys.Visita;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface VisitaRepository extends JpaRepository<Visita, Long> {
    List<Visita> findByUsuario(Usuario usuario);
    List<Visita> findByUsuarioAndDataServicoGreaterThanEqual(Usuario usuario, LocalDate data);

    Optional<Visita> findByIdAndUsuario(Long id, Usuario usuario);
}