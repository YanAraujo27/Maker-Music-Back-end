package app.scr.makermusic.service;

import app.scr.makermusic.domain.Feedback;
import app.scr.makermusic.domain.Materia;
import app.scr.makermusic.domain.Usuario;
import app.scr.makermusic.dto.request.FeedbackRequest;
import app.scr.makermusic.dto.response.FeedbackResponse;
import app.scr.makermusic.exception.AlunoNotFoundException;
import app.scr.makermusic.exception.MateriaNotFoundException;
import app.scr.makermusic.exception.ProfessorNotFoundException;
import app.scr.makermusic.repository.FeedbackRepository;
import app.scr.makermusic.repository.MateriaRepository;
import app.scr.makermusic.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private MateriaRepository materiaRepository;

    public FeedbackResponse createFeedback(FeedbackRequest request) {
        // Busca a matéria no banco de dados
        Materia materia = materiaRepository.findById(request.getMateriaId())
                .orElseThrow(() -> new MateriaNotFoundException("Matéria não cadastrada"));

        // Busca o professor
        Usuario professor = usuarioRepository.findById(request.getProfessorId())
                .orElseThrow(() -> new ProfessorNotFoundException("Professor não cadastrado"));

        // Busca o aluno
        Usuario aluno = usuarioRepository.findById(request.getAlunoId())
                .orElseThrow(() -> new AlunoNotFoundException("Aluno não cadastrado"));

        // Cria o Feedback
        Feedback feedback = Feedback.builder()
                .comentario(request.getComentario())
                .data(LocalDateTime.now())
                .materia(materia)
                .professor(professor)
                .aluno(aluno)
                .build();

        // Salva o Feedback
        feedback = feedbackRepository.save(feedback);

        // Retorna a resposta
        return new FeedbackResponse(feedback.getComentario(), feedback.getAluno().getId());
    }

    public List<FeedbackResponse> getFeedbacksByAlunoId(Long alunoId) {
        return feedbackRepository.findByAlunoId(alunoId).stream()
                .map(feedback -> new FeedbackResponse(feedback.getComentario(), feedback.getAluno().getId()))
                .collect(Collectors.toList());
    }
}