package org.modulemob.postesservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class PosteHistoryDTO {
    private String posteId;
    private List<CollabDTO> collabDTOS;
    private List<CompetenceDTO> competenceDTOS;
}
