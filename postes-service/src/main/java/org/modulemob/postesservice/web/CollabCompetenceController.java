package org.modulemob.postesservice.web;

import org.modulemob.postesservice.dto.PosteDTO;
import org.modulemob.postesservice.mapper.PosteMapperImpl;
import org.modulemob.postesservice.service.CollabCompetenceService;
import org.modulemob.postesservice.service.PosteCompetenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/collabs")
public class CollabCompetenceController {

    @Autowired
    private PosteMapperImpl dtoMapper;
    private final CollabCompetenceService collabCompetenceService;

    @Autowired
    public CollabCompetenceController(CollabCompetenceService collabCompetenceService) {
        this.collabCompetenceService = collabCompetenceService;
    }



    @PostMapping("/competenceLevel")
    public ResponseEntity<String> addCompetenceWithLevelToCollab(
            @RequestParam Long collabId,
            @RequestParam String competenceId,
            @RequestParam String level) {
        collabCompetenceService.addCompetenceWithLevelToCollab(collabId, competenceId, level);
        return ResponseEntity.status(HttpStatus.CREATED).body("Competence with level added to collab successfully");
    }

}
