package org.modulemob.postesservice.entities;

import jakarta.persistence.*;
import lombok.*;
import jakarta.persistence.Id;


import java.io.Serializable;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class PosteCompetence implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "poste_id")
    private Poste poste;

    @ManyToOne
    @JoinColumn(name = "competence_id")
    private Competence competence;

    private String level;

    public PosteCompetence(Poste poste, Competence competence, String level) {
        this.poste = poste;
        this.competence = competence;
        this.level = level;
    }
}