package org.modulemob.postesservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.modulemob.postesservice.enums.AccountStatus;

import java.io.Serializable;
import java.util.*;

@Entity(name = "Poste")
@Table(name = "poste")
@NoArgsConstructor @AllArgsConstructor @Builder
@Getter @Setter @ToString @Data

public class Poste implements Serializable {
    @Id
    private String id;
    private String titre;
    private String description;
    @Enumerated(EnumType.STRING)
    private AccountStatus status;
    private Date creationDate;
    private double salary;
    private String contractType;
    private String team;


    @OneToMany(
            mappedBy = "poste",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<PosteCompetence> posteCompetences = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "collab_id")
    private Collab collab;
}



//
//    @JsonIgnore
//    @ManyToMany
//    private List<Competence> competences= new ArrayList<>();
//
//
//    // Intermediate table for many-to-many relationship
//    @OneToMany(mappedBy = "poste", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<PosteCompetence> posteCompetences = new ArrayList<>();


    //    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
//    @JoinTable(
//            name = "poste_competence",
//            joinColumns = @JoinColumn(name = "poste_id"),
//            inverseJoinColumns = @JoinColumn(name = "competence_id")
//    )
//
////    @JsonIgnore
//    private Set<Competence> competences= new HashSet<>();
//



