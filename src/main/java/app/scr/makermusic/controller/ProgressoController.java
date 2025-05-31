package app.scr.makermusic.controller;


import app.scr.makermusic.domain.MateriaPorAluno;
import app.scr.makermusic.dto.request.AtualizarProgressoRequest;
import app.scr.makermusic.dto.response.MateriaProgressoResponse;
import app.scr.makermusic.repository.MateriaPorAlunoRepository;
import app.scr.makermusic.service.ProgressoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/progresso")
public class ProgressoController {

    @Autowired
    private MateriaPorAlunoRepository materiaPorAlunoRepository;

    @Autowired
    private ProgressoService progressoService;

    @GetMapping("/{alunoId}")
    @PreAuthorize("hasAnyAuthority('RESPONSAVEL', 'PROFESSOR')")
    public ResponseEntity<List<MateriaPorAluno>> getProgresso(@PathVariable Long alunoId) {
        List<MateriaPorAluno> progresso = materiaPorAlunoRepository.findByAlunoId(alunoId);
        return ResponseEntity.ok(progresso);
    }

    @PreAuthorize("hasAuthority('PROFESSOR')")
    @PutMapping("/atualizar")
    public ResponseEntity<String> atualizarProgresso(@RequestBody AtualizarProgressoRequest request) {
        progressoService.atualizarProgresso(request);
        return ResponseEntity.ok("Progresso atualizado com sucesso");
    }
}
