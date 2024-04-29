package org.modulemob.postesservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.NaturalId;

import java.io.Serializable;
import java.util.*;

@Entity(name = "Competence")
@Table(name = "Competence")
@Data @NoArgsConstructor @AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Competence implements Serializable {

    @Id
    private String id;
    @NaturalId
    private String nom;
    private String description;


    @JsonIgnore
    @OneToMany(
            mappedBy = "competence",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<PosteCompetence> posteCompetences = new ArrayList<>();


    @JsonIgnore
    @OneToMany(
            mappedBy = "competence",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<CollabCompetence> collabCompetences = new ArrayList<>();

    public Competence(String nom) {
        this.nom = nom;
    }



}






//    @ManyToMany(mappedBy = "competences" )
//    @JsonIgnore
//    private List<Poste> postes = new ArrayList<>();


//    @ManyToMany(mappedBy = "competences" ,fetch = FetchType.LAZY)
//    private Set<Collab> collaborateurs;

//*   @ManyToMany(mappedBy = "competences" )
//    , fetch = FetchType.LAZY,
//            cascade = {
//                    CascadeType.PERSIST,
//                    CascadeType.MERGE
//            })*/


