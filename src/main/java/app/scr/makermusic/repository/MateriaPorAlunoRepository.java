package app.scr.makermusic.repository;

import app.scr.makermusic.domain.MateriaPorAluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MateriaPorAlunoRepository extends JpaRepository<MateriaPorAluno, Long> {
    Optional<MateriaPorAluno> findByAlunoIdAndMateriaId(Long alunoId, Long materiaId);
    List<MateriaPorAluno> findByAlunoId(Long alunoId);
}