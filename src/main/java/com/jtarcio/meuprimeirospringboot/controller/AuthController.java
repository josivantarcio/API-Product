package com.jtarcio.meuprimeirospringboot.controller;

import com.jtarcio.meuprimeirospringboot.model.Usuario;
import com.jtarcio.meuprimeirospringboot.security.JwtUtil;
import com.jtarcio.meuprimeirospringboot.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UsuarioService usuarioService;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, String> request){
        Usuario usuario = usuarioService.registrarUsuario(
                request.get("username"),
                request.get("password")
        );
        return ResponseEntity.ok(usuario);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> request){
        Usuario usuario = usuarioService.findUser(request.get("username"));

        if(passwordEncoder.matches(request.get("password"), usuario.getPassword())){
            String token = JwtUtil.generateToken(usuario.getUsername());
            return ResponseEntity.ok(Map.of("token", token));
        }

        return ResponseEntity.status(401).body("Credenciais Invalidas");
    }
}