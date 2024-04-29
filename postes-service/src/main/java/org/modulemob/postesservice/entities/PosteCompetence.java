package org.modulemob.postesservice.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import jakarta.persistence.Id;
import org.modulemob.postesservice.embadded.PosteCompetenceId;


import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity(name = "PosteCompetence")
@Table(name = "poste_competence")

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data

public class PosteCompetence {

    @EmbeddedId
    private PosteCompetenceId id;


    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("posteId")
    @JsonIgnore
    private Poste poste;


    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("competenceId")
    @JsonIgnore
    private Competence competence;

    @Column(name = "rated_on")
    private Date ratedOn = new Date();

    @Column(name = "level")
    private String level;


    public PosteCompetence(Poste poste, Competence competence) {
        this.poste = poste;
        this.competence = competence;
        this.id = new PosteCompetenceId(poste.getId() , competence.getId());
    }











    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        PosteCompetence that = (PosteCompetence) o;
        return Objects.equals(poste, that.poste) &&
                Objects.equals(competence, that.competence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(poste, competence);
    }
}