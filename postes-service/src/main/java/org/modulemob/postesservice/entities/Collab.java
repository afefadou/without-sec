package org.modulemob.postesservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Collab {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String email;

    @OneToOne
    @JoinColumn(name = "poste_id", unique = true, nullable = false)
    private Poste poste;

    @ManyToMany
    @JoinTable(
            name = "collab_competence",
            joinColumns = @JoinColumn(name = "collab_id"),
            inverseJoinColumns = @JoinColumn(name = "competence_id")
    )
    private Set<Competence> competences;
}
