package app.scr.makermusic.utils;

import app.scr.makermusic.domain.Evento;
import app.scr.makermusic.repository.EventoRepository;
import app.scr.makermusic.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class LembreteScheduler {

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private EmailService emailService;

    // Executa todos os dias à meia-noite
    @Scheduled(cron = "0 0 0 * * *")
    public void enviarLembretes() {
        LocalDateTime agora = LocalDateTime.now();
        LocalDateTime alvo = agora.plusHours(24);
        List<Evento> eventos = eventoRepository.findByDataBetween(agora, alvo);

        for (Evento evento : eventos) {
            emailService.enviarEmail("todos@escola.com",
                    "Lembrete de Evento: " + evento.getTitulo(),
                    "Lembrete: " + evento.getDescricao());
        }
    }
}
