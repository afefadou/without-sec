package org.modulemob.postesservice.web;

import org.modulemob.postesservice.dto.PosteDTO;
import org.modulemob.postesservice.mapper.PosteMapperImpl;
import org.modulemob.postesservice.service.PosteCompetenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/postes")
public class CollabCompetenceController {

    @Autowired
    private PosteMapperImpl dtoMapper;
    private final PosteCompetenceService posteCompetenceService;

    @Autowired
    public CollabCompetenceController(PosteCompetenceService posteCompetenceService) {
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

//    @GetMapping("/list")
//
//    public List<Poste> postes() {
//        //  System.out.println("fidaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//        return posteCompetenceService.listPostes();
//    }


    @GetMapping("/postesdto")
    public List<PosteDTO> listPostes() {
        return posteCompetenceService.listPostes();
    }
}
