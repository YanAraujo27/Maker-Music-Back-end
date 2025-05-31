package app.scr.makermusic.controller;


import app.scr.makermusic.domain.Usuario;
import app.scr.makermusic.dto.response.AuthResponse;
import app.scr.makermusic.dto.request.LoginRequest;
import app.scr.makermusic.exception.InvalidAuthorizationException;
import app.scr.makermusic.repository.UsuarioRepository;
import app.scr.makermusic.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil;
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthController(JwtUtil jwtUtil, UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.jwtUtil = jwtUtil;
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        if (request.getEmail() == null || request.getEmail().isEmpty()) {
            throw new InvalidAuthorizationException("Email é obrigatório");
        }

        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(request.getEmail());
        if (!usuarioOpt.isPresent()) {
            throw new InvalidAuthorizationException("Usuário não encontrado");
        }

        Usuario usuario = usuarioOpt.get();

        if (!passwordEncoder.matches(request.getSenha(), usuario.getSenha())) {
            throw new InvalidAuthorizationException("Senha inválida");
        }

        String role = usuario.getRole().name();
        String token = jwtUtil.generateToken(usuario.getEmail(), role);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new AuthResponse(201, token));
    }
}
