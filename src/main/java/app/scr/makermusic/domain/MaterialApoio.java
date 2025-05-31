package app.scr.makermusic.domain;

import app.scr.makermusic.enums.TipoMaterial;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "material_apoio")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MaterialApoio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    @Enumerated(EnumType.STRING)
    private TipoMaterial tipo;
    private String url;
    @ManyToOne
    @JoinColumn(name = "materia_id")
    private Materia materia;
}
