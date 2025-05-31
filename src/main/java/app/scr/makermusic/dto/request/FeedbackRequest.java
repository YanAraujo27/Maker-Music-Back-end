package app.scr.makermusic.dto.request;

import lombok.Data;

@Data
public class FeedbackRequest {
    private String comentario;
    private Long materiaId;
    private Long professorId;
    private Long alunoId;
}
