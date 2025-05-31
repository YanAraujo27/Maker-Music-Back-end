package app.scr.makermusic.repository;

import app.scr.makermusic.domain.Materia;
import app.scr.makermusic.domain.MateriaAlunoProgresso;
import app.scr.makermusic.domain.MaterialApoio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MateriaRepository extends JpaRepository<Materia, Long> {
    @Query("SELECT m FROM Materia m JOIN m.alunosConcluidos a WHERE a.id = :alunoId")
    List<Materia> findConcluidasByAlunoId(Long alunoId);

    @Query("""
        SELECT m.id as materiaId, m.nome as nome, mp.porcentagem as progresso
        FROM Materia m
        JOIN m.materiasPorAluno mp
        WHERE mp.aluno.id = :alunoId
    """)
    List<MateriaAlunoProgresso> findProgressoByAlunoId(Long alunoId);
}
