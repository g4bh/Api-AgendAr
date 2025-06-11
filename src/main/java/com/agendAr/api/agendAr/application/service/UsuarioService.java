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
        Usuario usuario = new Usuario(
                dto.getNome(),
                dto.getTelefone(),
                dto.getEmail(),
                dto.getSenha()
        );
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> login(UsuarioLoginDTO dto) {
        return usuarioRepository.findByEmail(dto.getEmail());
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
