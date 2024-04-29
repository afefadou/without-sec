package org.modulemob.postesservice.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modulemob.postesservice.enums.AccountStatus;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PosteDTO {
    private String id;
    private String titre;
    private String description;
    private AccountStatus status;
    private Date creationDate;
    private Date closureDate;
    private double salary;
    private String contractType;
    private String team;
    private CollabDTO collab;
    private PosteCompetenceDTO postecompetence;

}
