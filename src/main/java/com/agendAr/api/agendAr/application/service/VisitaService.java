package com.agendAr.api.agendAr.application.service;

import com.agendAr.api.agendAr.application.repository.Visita.VisitaRepository;
import com.agendAr.api.agendAr.domain.dto.VisitaDTO;
import com.agendAr.api.agendAr.domain.entitys.Usuario;
import com.agendAr.api.agendAr.domain.entitys.Visita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class VisitaService {

    @Autowired
    private VisitaRepository visitaRepository;

    public Visita criarVisita(VisitaDTO dto, Usuario usuario) {
        Visita visita = new Visita(
                dto.getTipoServico(),
                dto.getDataServico(),
                dto.getHoraServico(),
                dto.getCepEndereco(),
                dto.getEndereco(),
                dto.getNumeroResidencia(),
                dto.getCidade(),
                dto.getNomeAcolhedor(),
                usuario
        );
        return visitaRepository.save(visita);
    }

    public List<Visita> listarVisitasPorUsuario(Usuario usuario) {
        return visitaRepository.findByUsuario(usuario);
    }

    public Optional<Visita> buscarVisitaPorId(Long id, Usuario usuario) {
        return visitaRepository.findByIdAndUsuario(id, usuario);
    }

    public void cancelarVisita(Long id, Usuario usuario) {
        Optional<Visita> visita = visitaRepository.findByIdAndUsuario(id, usuario);
        visita.ifPresent(visitaRepository::delete);
    }

    public List<Visita> visitasProximas(Usuario usuario) {
        LocalDate hoje = LocalDate.now();
        return visitaRepository.findByUsuarioAndDataServicoGreaterThanEqual(usuario, hoje);
    }
}
