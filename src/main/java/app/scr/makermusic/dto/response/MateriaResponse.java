package app.scr.makermusic.dto.response;


import app.scr.makermusic.domain.Materia;
import lombok.Data;

@Data
public class MateriaResponse {
    private Long id;
    private String nome;
    private String descricao;

    public MateriaResponse(Materia materia) {
        this.id = materia.getId();
        this.nome = materia.getNome();
        this.descricao = materia.getDescricao();
    }
}