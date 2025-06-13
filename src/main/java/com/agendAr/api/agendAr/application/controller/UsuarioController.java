package com.agendAr.api.agendAr.application.controller;

import com.agendAr.api.agendAr.application.service.UsuarioService;
import com.agendAr.api.agendAr.domain.dto.UsuarioCadastroDTO;
import com.agendAr.api.agendAr.domain.dto.UsuarioLoginDTO;
import com.agendAr.api.agendAr.domain.entitys.Usuario;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/cadastro")
    public ResponseEntity<?> cadastrar(@RequestBody UsuarioCadastroDTO dto) {
        try {
            Usuario novoUsuario = usuarioService.cadastrarUsuario(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
        } catch (IllegalArgumentException e) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(e.getMessage()); // mensagem de erro customizada
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UsuarioLoginDTO dto) {
        Optional<Usuario> usuario = usuarioService.login(dto);

        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario.get());
        } else {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("E-mail ou senha inválidos."); // 401 Unauthorized
        }
    }

    @PutMapping("/{id}")
    public Usuario atualizar(@PathVariable Long id, @RequestBody UsuarioCadastroDTO dto) {
        return usuarioService.atualizarUsuario(id, dto);
    }
}
