package com.agendAr.api.agendAr.application.service;

import com.agendAr.api.agendAr.application.repository.Usuario.UsuarioRepository;
import com.agendAr.api.agendAr.domain.dto.UsuarioCadastroDTO;
import com.agendAr.api.agendAr.domain.dto.UsuarioLoginDTO;
import com.agendAr.api.agendAr.domain.entitys.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    private final Map<String, Usuario> tokens = new HashMap<>();


    public Usuario cadastrarUsuario(UsuarioCadastroDTO dto) {
        Optional<Usuario> existente = usuarioRepository.findByEmail(dto.getEmail());

        if (existente.isPresent()) {
            throw new IllegalArgumentException("Este e-mail já está cadastrado.");
        }

        Usuario novo = new Usuario(dto.getNome(), dto.getTelefone(), dto.getEmail(), dto.getSenha());
        return usuarioRepository.save(novo);
    }

    public Optional<Usuario> login(UsuarioLoginDTO dto) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findByEmail(dto.getEmail());

        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();

            if (usuario.getSenha().equals(dto.getSenha())) {
                return Optional.of(usuario);
            }
        }

        return Optional.empty();
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario getUsuarioPorToken(String token) {
        Usuario usuario = tokens.get(token);
        if (usuario == null) {
            throw new RuntimeException("Token inválido");
        }
        return usuario;
    }

    public Usuario atualizarUsuario(Long id, UsuarioCadastroDTO dto) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            usuario.setEmail(dto.getEmail());
            usuario.setTelefone(dto.getTelefone());
            usuario.setSenha(dto.getSenha());
            return usuarioRepository.save(usuario);
        }
        return null;
    }
}
