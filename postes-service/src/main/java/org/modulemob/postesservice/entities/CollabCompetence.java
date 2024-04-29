package org.modulemob.postesservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import org.modulemob.postesservice.embadded.CollabCompetenceId;
import org.modulemob.postesservice.entities.Collab;
import org.modulemob.postesservice.entities.Competence;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity(name = "CollabCompetence")
@Table(name = "collab_competence")

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data

public class CollabCompetence implements Serializable {


    @EmbeddedId
    private CollabCompetenceId id;


    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("collabId")
    @JsonIgnore
    private Collab collab;


    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("competenceId")
    @JsonIgnore
    private Competence competence;

    @Column(name = "rated_on")
    private Date ratedOn = new Date();

    @Column(name = "level")
    private String level;


    public CollabCompetence(Collab collab, Competence competence) {
        this.collab = collab;
        this.competence = competence;
        this.id = new CollabCompetenceId(collab.getId() , competence.getId());
    }











    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        CollabCompetence that = (CollabCompetence) o;
        return Objects.equals(collab, that.collab) &&
                Objects.equals(competence, that.competence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(collab, competence);
    }
}