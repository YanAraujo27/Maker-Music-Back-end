package app.scr.makermusic.controller;

import app.scr.makermusic.domain.Usuario;
import app.scr.makermusic.dto.response.ApiResponse;
import app.scr.makermusic.dto.request.RegisterRequest;
import app.scr.makermusic.enums.Role;
import app.scr.makermusic.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationController {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/admin")
    public ResponseEntity<?> registerAdmin(@RequestBody RegisterRequest request) {
        if (usuarioRepository.existsByRole(Role.ADMIN)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body(new ApiResponse(403, "Admin já cadastrado. Cadastro de novo admin requer autenticação."));
        }
        Usuario admin = Usuario.builder()
                .nome(request.getNome())
                .email(request.getEmail())
                .senha(passwordEncoder.encode(request.getSenha()))
                .role(Role.ADMIN)
                .build();
        usuarioRepository.save(admin);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse(201, "Admin cadastrado com sucesso!"));
    }


    @PreAuthorize("hasAnyAuthority('ADMIN', 'PROFESSOR')")
    @PostMapping("/professor")
    public ResponseEntity<?> registerProfessor(@RequestBody RegisterRequest request) {
        System.out.println("Autenticação: " + SecurityContextHolder.getContext().getAuthentication());
        if (usuarioRepository.findByEmail(request.getEmail()).isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse(400, "Professor já cadastrado"));
        }
        Usuario professor = Usuario.builder()
                .nome(request.getNome())
                .email(request.getEmail())
                .senha(passwordEncoder.encode(request.getSenha()))
                .role(Role.PROFESSOR)
                .build();
        usuarioRepository.save(professor);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse(201, "Professor cadastrado com sucesso!"));
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'PROFESSOR')")
    @PostMapping("/aluno")
    public ResponseEntity<?> registerAluno(@RequestBody RegisterRequest request) {
        if (usuarioRepository.findByEmail(request.getEmail()).isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse(400, "Aluno já cadastrado"));
        }
        Usuario aluno = Usuario.builder()
                .nome(request.getNome())
                .email(request.getEmail())
                .senha(passwordEncoder.encode(request.getSenha()))
                .role(Role.ALUNO)
                .build();
        usuarioRepository.save(aluno);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse(201, "Aluno cadastrado com sucesso!"));
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'PROFESSOR')")
    @PostMapping("/responsavel")
    public ResponseEntity<?> registerResponsavel(@RequestBody RegisterRequest request) {
        if (usuarioRepository.findByEmail(request.getEmail()).isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse(400, "Responsavel já cadastrado"));
        }
        Usuario responsavel = Usuario.builder()
                .nome(request.getNome())
                .email(request.getEmail())
                .senha(passwordEncoder.encode(request.getSenha()))
                .role(Role.RESPONSAVEL)
                .build();
        usuarioRepository.save(responsavel);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse(201, "Responsável cadastrado com sucesso!"));
    }
}
