package app.scr.makermusic.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "feedbacks")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comentario;
    private LocalDateTime data;
    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Usuario aluno;
    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Usuario professor;
    @ManyToOne
    @JoinColumn(name = "materia_id")
    private Materia materia;
}