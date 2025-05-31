package app.scr.makermusic.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MateriaProgressoResponse {
    private Long materiaId;
    private String nome;
    private Double progresso;
}