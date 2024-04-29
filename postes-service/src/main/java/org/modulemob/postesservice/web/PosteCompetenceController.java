package org.modulemob.postesservice.web;

import org.modulemob.postesservice.service.PosteCompetenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/poste-competence")
public class PosteCompetenceController {

    private final PosteCompetenceService posteCompetenceService;

    @Autowired
    public PosteCompetenceController(PosteCompetenceService posteCompetenceService) {
        this.posteCompetenceService = posteCompetenceService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addCompetenceWithLevelToPoste(
            @RequestParam String posteId,
            @RequestParam String competenceId,
            @RequestParam String level) {
        posteCompetenceService.addCompetenceWithLevelToPoste(posteId, competenceId, level);
        return ResponseEntity.status(HttpStatus.CREATED).body("Competence with level added to poste successfully");
    }
}
