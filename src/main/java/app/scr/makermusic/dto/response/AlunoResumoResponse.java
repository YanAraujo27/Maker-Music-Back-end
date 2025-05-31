package app.scr.makermusic.dto.response;

public class AlunoResumoResponse {
    private Long aluno_id;
    private String nome_aluno;

    public AlunoResumoResponse(Long aluno_id, String nome_aluno) {
        this.aluno_id = aluno_id;
        this.nome_aluno = nome_aluno;
    }

    public Long getAluno_id() {
        return aluno_id;
    }

    public String getNome_aluno() {
        return nome_aluno;
    }
}
