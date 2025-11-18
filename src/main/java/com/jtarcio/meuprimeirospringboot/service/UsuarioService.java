package com.jtarcio.meuprimeirospringboot.service;

import com.jtarcio.meuprimeirospringboot.exceptions.RecursoNaoEncontradoException;
import com.jtarcio.meuprimeirospringboot.model.Usuario;
import com.jtarcio.meuprimeirospringboot.repository.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public Usuario registrarUsuario(String name, String password) {
        String senhaCripto = passwordEncoder.encode(password);

        Usuario user = new Usuario(name, senhaCripto);
        return usuarioRepository.save(user);
    }

    public Usuario findUser(String name){
        return usuarioRepository.findUsuarioByUsername(name)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Usuario " + name + " não localizado"));
    }
}