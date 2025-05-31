package app.scr.makermusic.service;

import app.scr.makermusic.repository.AlunoResponsavelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoResponsavelService {

    @Autowired
    private AlunoResponsavelRepository repository;

    public void associar(Long alunoId, Long responsavelId) {
        repository.associar(alunoId, responsavelId);
    }
}