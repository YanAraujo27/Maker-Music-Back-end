package app.scr.makermusic.controller;

import app.scr.makermusic.service.AlunoResponsavelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aluno-responsavel")
public class AlunoResponsavelController {

    @Autowired
    private AlunoResponsavelService alunoResponsavelService;

    @PostMapping
    public String associarAlunoResponsavel(@RequestParam Long alunoId, @RequestParam Long responsavelId) {
        alunoResponsavelService.associar(alunoId, responsavelId);
        return "Associação realizada com sucesso!";
    }
}