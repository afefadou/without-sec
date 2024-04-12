package org.modulemob.postesservice.entities;

import jakarta.persistence.*;
import lombok.*;
import org.modulemob.postesservice.enums.AccountStatus;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor @AllArgsConstructor @Builder
@Getter @Setter @ToString @Data

public class Poste {
    @Id

    private String id;
    private String titre;
    private String description;
    @Enumerated(EnumType.STRING)
    private AccountStatus status;
    private Date creationDate;
    private Date closureDate;
    private double salary;
    private String contractType;
    private String team;

    @OneToOne(mappedBy = "poste", cascade = CascadeType.ALL, optional = true)
    private Collab collab;

    @ManyToMany
    @JoinTable(
            name = "poste_competence",
            joinColumns = @JoinColumn(name = "poste_id"),
            inverseJoinColumns = @JoinColumn(name = "competence_id")
    )
    private Set<Competence> competences;

}
