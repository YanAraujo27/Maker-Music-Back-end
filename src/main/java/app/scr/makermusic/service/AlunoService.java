package app.scr.makermusic.service;

import app.scr.makermusic.domain.Materia;
import app.scr.makermusic.domain.Usuario;
import app.scr.makermusic.dto.response.FeedbackResponse;
import app.scr.makermusic.repository.MateriaRepository;
import app.scr.makermusic.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AlunoService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private MateriaRepository materiaRepository;

    @Autowired
    private FeedbackService feedbackService;

    public List<Usuario> getAlunosByResponsavelId(Long responsavelId) {
        return usuarioRepository.findAlunosByResponsavelId(responsavelId);
    }

    public Map<String, Object> getProgressoByAlunoId(Long alunoId) {
        List<Materia> concluidas = materiaRepository.findConcluidasByAlunoId(alunoId);
        List<FeedbackResponse> feedbacks = feedbackService.getFeedbacksByAlunoId(alunoId);
        return Map.of("materiasConcluidas", concluidas, "feedbacks", feedbacks);
    }
}