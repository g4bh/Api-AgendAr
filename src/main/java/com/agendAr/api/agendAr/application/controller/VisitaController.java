package com.agendAr.api.agendAr.application.controller;

import com.agendAr.api.agendAr.application.service.UsuarioService;
import com.agendAr.api.agendAr.application.service.VisitaService;
import com.agendAr.api.agendAr.domain.dto.VisitaDTO;
import com.agendAr.api.agendAr.domain.entitys.Usuario;
import com.agendAr.api.agendAr.domain.entitys.Visita;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/visitas")
public class VisitaController {

    @Autowired
    private VisitaService visitaService;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/usuario/{id}")
    public Visita criarVisita(@PathVariable Long id, @RequestBody VisitaDTO dto) {
        Optional<Usuario> usuario = usuarioService.buscarPorId(id);
        return usuario.map(u -> visitaService.criarVisita(dto, u)).orElse(null);
    }

    @GetMapping("/usuario/{id}")
    public List<Visita> listarVisitas(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioService.buscarPorId(id);
        return usuario.map(visitaService::listarVisitasPorUsuario).orElse(null);
    }

    @GetMapping("/{idVisita}/usuario/{idUsuario}")
    public Visita buscarVisita(@PathVariable Long idVisita, @PathVariable Long idUsuario) {
        Optional<Usuario> usuario = usuarioService.buscarPorId(idUsuario);
        return usuario.flatMap(u -> visitaService.buscarVisitaPorId(idVisita, u)).orElse(null);
    }

    @DeleteMapping("/{idVisita}/usuario/{idUsuario}")
    public void cancelar(@PathVariable Long idVisita, @PathVariable Long idUsuario) {
        Optional<Usuario> usuario = usuarioService.buscarPorId(idUsuario);
        usuario.ifPresent(u -> visitaService.cancelarVisita(idVisita, u));
    }

    @GetMapping("/proximas/usuario/{id}")
    public List<Visita> visitasProximas(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioService.buscarPorId(id);
        return usuario.map(visitaService::visitasProximas).orElse(null);
    }
}
