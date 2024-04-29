package org.modulemob.postesservice.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity @Builder
@Getter
@Setter
@ToString
public class  Collab {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String email;
    private Date collabDate;


    @OneToMany(
            mappedBy = "collab",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<CollabCompetence> collabCompetences = new ArrayList<>();


}


//// @OneToOne(mappedBy = "collab")
//    //private Poste poste;
//
//    @ManyToMany
////    @JoinTable(
////            name = "collab_competence",
////            joinColumns = @JoinColumn(name = "collab_id"),
////            inverseJoinColumns = @JoinColumn(name = "competence_id")
////    )
//    private List<Competence> competences = new ArrayList<>();
//}
