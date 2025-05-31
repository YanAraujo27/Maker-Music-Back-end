package app.scr.makermusic.controller;

import app.scr.makermusic.domain.Materia;
import app.scr.makermusic.repository.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/materias")
public class MateriaController {

    @Autowired
    private MateriaRepository materiaRepository;

    @GetMapping
    public List<Materia> getAllMaterias() {
        return materiaRepository.findAll();
    }

    @PostMapping
    public Materia createMateria(@RequestBody Materia materia) {
        return materiaRepository.save(materia);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Materia> getMateriaById(@PathVariable Long id) {
        return materiaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Materia> updateMateria(@PathVariable Long id, @RequestBody Materia updatedMateria) {
        return materiaRepository.findById(id)
                .map(materia -> {
                    materia.setNome(updatedMateria.getNome());
                    materia.setDescricao(updatedMateria.getDescricao());
                    return ResponseEntity.ok(materiaRepository.save(materia));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteMateria(@PathVariable Long id) {
        return materiaRepository.findById(id)
                .map(materia -> {
                    materiaRepository.delete(materia);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}