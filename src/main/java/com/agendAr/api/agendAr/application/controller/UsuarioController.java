package com.agendAr.api.agendAr.application.controller;

import com.agendAr.api.agendAr.application.service.UsuarioService;
import com.agendAr.api.agendAr.domain.dto.UsuarioCadastroDTO;
import com.agendAr.api.agendAr.domain.dto.UsuarioLoginDTO;
import com.agendAr.api.agendAr.domain.entitys.Usuario;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/cadastro")
    public Usuario cadastrar(@RequestBody UsuarioCadastroDTO dto) {
        return usuarioService.cadastrarUsuario(dto);
    }

    @PostMapping("/login")
    public Usuario login(@RequestBody UsuarioLoginDTO dto) {
        Optional<Usuario> usuario = usuarioService.login(dto);
        return usuario.orElse(null);
    }

    @PutMapping("/{id}")
    public Usuario atualizar(@PathVariable Long id, @RequestBody UsuarioCadastroDTO dto) {
        return usuarioService.atualizarUsuario(id, dto);
    }
}
