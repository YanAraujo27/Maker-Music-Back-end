package app.scr.makermusic.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FeedbackResponse {
    private String comentario;
    private Long alunoId;
}
