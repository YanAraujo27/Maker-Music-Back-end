package app.scr.makermusic.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class AlunoResponsavelRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void associar(Long alunoId, Long responsavelId) {
        em.createNativeQuery("INSERT INTO aluno_responsavel (aluno_id, responsavel_id) VALUES (:alunoId, :responsavelId)")
                .setParameter("alunoId", alunoId)
                .setParameter("responsavelId", responsavelId)
                .executeUpdate();
    }
}
