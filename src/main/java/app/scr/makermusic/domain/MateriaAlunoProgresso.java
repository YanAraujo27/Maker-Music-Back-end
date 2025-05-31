package app.scr.makermusic.domain;

public interface MateriaAlunoProgresso {
    Long getMateriaId();
    String getNome();
    Double getProgresso(); // de 0 a 100
}
