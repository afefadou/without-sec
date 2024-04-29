package org.modulemob.postesservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modulemob.postesservice.embadded.CollabCompetenceId;
import org.modulemob.postesservice.embadded.PosteCompetenceId;
import org.modulemob.postesservice.entities.Collab;
import org.modulemob.postesservice.entities.Competence;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CollabCompetenceDTO {


    private CollabCompetenceId id;

    private Collab collab;

    private Competence competence;

    private Date ratedOn = new Date();
    private String level;


}
