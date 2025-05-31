package app.scr.makermusic.controller;

import app.scr.makermusic.domain.Usuario;
import app.scr.makermusic.dto.response.AlunoResumoResponse;
import app.scr.makermusic.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/responsavel")
public class ResponsavelController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/{responsavelId}")
    public List<AlunoResumoResponse> listarAlunosDoResponsavel(@PathVariable Long responsavelId) {
        return usuarioRepository.findAlunosResumoByResponsavelId(responsavelId);
    }
}
