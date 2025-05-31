package app.scr.makermusic.controller;

import app.scr.makermusic.domain.Evento;
import app.scr.makermusic.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoRepository eventoRepository;

    @PostMapping
    public ResponseEntity<Evento> criarEvento(@RequestBody Evento evento) {
        return ResponseEntity.ok(eventoRepository.save(evento));
    }

    @GetMapping("/proximos")
    public ResponseEntity<List<Evento>> listarEventosProximos() {
        List<Evento> eventos = eventoRepository.findByDataAfter(LocalDateTime.now());
        return ResponseEntity.ok(eventos);
    }
}