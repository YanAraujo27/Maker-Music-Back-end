package app.scr.makermusic.service;

import app.scr.makermusic.domain.Materia;
import app.scr.makermusic.domain.MateriaAlunoProgresso;
import app.scr.makermusic.domain.MateriaPorAluno;
import app.scr.makermusic.domain.Usuario;
import app.scr.makermusic.dto.request.AtualizarProgressoRequest;
import app.scr.makermusic.dto.response.MateriaProgressoResponse;
import app.scr.makermusic.exception.AlunoNotFoundException;
import app.scr.makermusic.exception.MateriaNotFoundException;
import app.scr.makermusic.repository.MateriaPorAlunoRepository;
import app.scr.makermusic.repository.MateriaRepository;
import app.scr.makermusic.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProgressoService {

    @Autowired
    private MateriaPorAlunoRepository materiaPorAlunoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private MateriaRepository materiaRepository;

    public void atualizarProgresso(AtualizarProgressoRequest request) {
        if (request.getPorcentagem() < 0 || request.getPorcentagem() > 100) {
            throw new IllegalArgumentException("Porcentagem deve estar entre 0 e 100.");
        }

        Usuario aluno = usuarioRepository.findById(request.getAlunoId())
                .orElseThrow(() -> new AlunoNotFoundException("Aluno não encontrado"));

        Materia materia = materiaRepository.findById(request.getMateriaId())
                .orElseThrow(() -> new MateriaNotFoundException("Matéria não encontrada"));

        MateriaPorAluno materiaPorAluno = materiaPorAlunoRepository
                .findByAlunoIdAndMateriaId(aluno.getId(), materia.getId())
                .orElse(MateriaPorAluno.builder()
                        .aluno(aluno)
                        .materia(materia)
                        .porcentagem(0.0)
                        .build());

        materiaPorAluno.setPorcentagem(request.getPorcentagem());
        materiaPorAlunoRepository.save(materiaPorAluno);
    }
}