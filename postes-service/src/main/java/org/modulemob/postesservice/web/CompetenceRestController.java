package org.modulemob.postesservice.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modulemob.postesservice.dto.CompetenceDTO;
import org.modulemob.postesservice.entities.PosteCompetence;
import org.modulemob.postesservice.exceptions.CompetenceNotFoundException;
import org.modulemob.postesservice.service.PosteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class CompetenceRestController {

    private final PosteService posteservice;


    @GetMapping("/competences/search")
    public List<CompetenceDTO> searchCompetences(@RequestParam(name = "keyword", defaultValue = "") String keyword) {
        return posteservice.searchCompetence("%" + keyword + "%");
    }


    @PutMapping("/competences/{competenceId}")
    public CompetenceDTO updateCompetence(@PathVariable String competenceId, @RequestBody CompetenceDTO competenceDTO) {
        competenceDTO.setId(competenceId);
        return posteservice.updateCompetence(competenceDTO);
    }



    @GetMapping("/competences/{id}")
    public CompetenceDTO getCompetenceById(@PathVariable String id) throws CompetenceNotFoundException {
        return posteservice.getCompetenceById(id);
    }

    @PostMapping("/competences")
    public CompetenceDTO saveCompetence(@RequestBody CompetenceDTO competenceDTO) {
        return posteservice.saveCompetence(competenceDTO);
    }

    @GetMapping("/competences")
    public List<CompetenceDTO> listCompetences() {
        return posteservice.listCompetences();
    }

    @DeleteMapping("/competences/{id}")
    public void deleteCompetence(@PathVariable String id) {
        posteservice.deleteCompetence(id);
    }

}
