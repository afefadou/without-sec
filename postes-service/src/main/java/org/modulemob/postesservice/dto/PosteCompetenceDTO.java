package org.modulemob.postesservice.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modulemob.postesservice.embadded.PosteCompetenceId;
import org.modulemob.postesservice.entities.Competence;
import org.modulemob.postesservice.entities.Poste;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PosteCompetenceDTO {

    private PosteCompetenceId id;
    private Competence competence;
    private Date ratedOn = new Date();
    private String level;

}
