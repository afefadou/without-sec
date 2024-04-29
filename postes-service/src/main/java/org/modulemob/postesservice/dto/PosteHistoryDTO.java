package org.modulemob.postesservice.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Data
public class PosteHistoryDTO {
    private String posteId;
    private int currentPage;
    private int totalPages;
    private int pageSize;
    private List<CollabDTO> collabDTOS;
    private List<CompetenceDTO> competenceDTOS;
}
