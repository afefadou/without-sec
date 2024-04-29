package org.modulemob.postesservice.web;

import org.modulemob.postesservice.dto.CompetenceDTO;
import org.modulemob.postesservice.dto.PosteDTO;
import org.modulemob.postesservice.entities.Poste;
import org.modulemob.postesservice.mapper.PosteMapperImpl;
import org.modulemob.postesservice.service.PosteCompetenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/postes")
public class PosteCompetenceController {

    @Autowired
    private PosteMapperImpl dtoMapper;
    private final PosteCompetenceService posteCompetenceService;

    @Autowired
    public PosteCompetenceController(PosteCompetenceService posteCompetenceService) {
        this.posteCompetenceService = posteCompetenceService;
    }

    @PostMapping("/competenceLevel")
    public ResponseEntity<String> addCompetenceWithLevelToPoste(
            @RequestParam String posteId,
            @RequestParam String competenceId,
            @RequestParam String level) {
        posteCompetenceService.addCompetenceWithLevelToPoste(posteId, competenceId, level);
        return ResponseEntity.status(HttpStatus.CREATED).body("Competence with level added to poste successfully");
    }

}
