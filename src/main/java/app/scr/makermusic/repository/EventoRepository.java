package app.scr.makermusic.repository;

import app.scr.makermusic.domain.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {

    List<Evento> findByDataAfter(LocalDateTime data);

    List<Evento> findByDataBetween(LocalDateTime inicio, LocalDateTime fim);

}