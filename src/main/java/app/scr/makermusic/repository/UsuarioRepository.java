package app.scr.makermusic.repository;

import app.scr.makermusic.domain.Usuario;
import app.scr.makermusic.dto.response.AlunoResumoResponse;
import app.scr.makermusic.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
    boolean existsByRole(Role role);

    @Query("SELECT a FROM Usuario a JOIN a.responsaveis r WHERE r.id = :responsavelId")
    List<Usuario> findAlunosByResponsavelId(Long responsavelId);

    @Query("SELECT new app.scr.makermusic.dto.response.AlunoResumoResponse(a.id, a.nome) FROM Usuario r JOIN r.alunos a WHERE r.id = :responsavelId")
    List<AlunoResumoResponse> findAlunosResumoByResponsavelId(@Param("responsavelId") Long responsavelId);

}

