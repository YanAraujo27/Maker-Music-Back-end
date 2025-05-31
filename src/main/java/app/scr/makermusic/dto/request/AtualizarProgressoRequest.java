package app.scr.makermusic.dto.request;

import lombok.Data;

@Data
public class AtualizarProgressoRequest {
    private Long alunoId;
    private Long materiaId;
    private Double porcentagem;
}