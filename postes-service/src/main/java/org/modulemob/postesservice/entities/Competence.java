package org.modulemob.postesservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Competence {
    @Id
    private String id;
    private String name;
    private String description;

    @ManyToMany(mappedBy = "competences")
    private Set<Collab> collaborateurs;

    @ManyToMany(mappedBy = "competences")
    private Set<Poste> postes;

}
