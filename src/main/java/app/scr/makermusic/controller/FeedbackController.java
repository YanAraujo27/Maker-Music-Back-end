package app.scr.makermusic.controller;

import app.scr.makermusic.domain.Feedback;
import app.scr.makermusic.domain.Materia;
import app.scr.makermusic.domain.Usuario;
import app.scr.makermusic.dto.request.FeedbackRequest;
import app.scr.makermusic.dto.response.FeedbackResponse;
import app.scr.makermusic.repository.FeedbackRepository;
import app.scr.makermusic.repository.UsuarioRepository;
import app.scr.makermusic.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @PreAuthorize("hasAuthority('PROFESSOR')")
    @PostMapping
    public ResponseEntity<FeedbackResponse> createFeedback(@RequestBody FeedbackRequest feedbackRequest) {
        FeedbackResponse response = feedbackService.createFeedback(feedbackRequest);
        return ResponseEntity.status(201).body(response);
    }

    @PreAuthorize("hasAnyAuthority('ALUNO', 'RESPONSAVEL')")
    @GetMapping("/aluno/{alunoId}")
    public ResponseEntity<List<FeedbackResponse>> getFeedbacksByAlunoId(@PathVariable Long alunoId) {
        List<FeedbackResponse> feedbacks = feedbackService.getFeedbacksByAlunoId(alunoId);
        return ResponseEntity.ok(feedbacks);
    }
}