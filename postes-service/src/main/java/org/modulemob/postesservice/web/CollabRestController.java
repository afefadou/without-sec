package org.modulemob.postesservice.web;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modulemob.postesservice.dto.CollabDTO;

import org.modulemob.postesservice.entities.Collab;
import org.modulemob.postesservice.exceptions.CollabNotFoundException;
import org.modulemob.postesservice.exceptions.PosteNotFoundException;
import org.modulemob.postesservice.service.PosteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class CollabRestController {

    private PosteService posteService;


    /*****poste rest controller**/


    @GetMapping("/collabs")
    public List<Collab> collabs(){
        return posteService.listeCollabs();
    }
    @GetMapping("/collabs/search")
    public List<CollabDTO> searchCollabs(@RequestParam(name = "keyword",defaultValue = "") String keyword){
        return posteService.searchCollabs("%"+keyword+"%");
    }
    @GetMapping("/collabs/{id}")
    public CollabDTO getCollabById(@PathVariable(name = "id") Long collabId) throws CollabNotFoundException {
        return posteService.getCollab(collabId);
    }
    @PostMapping("/collabs")
    public CollabDTO saveCollab(@RequestBody CollabDTO collabDTO){
        return posteService.saveCollab(collabDTO);
    }
    @PutMapping("/collabs/{collabId}")
    public CollabDTO updateCollab(@PathVariable Long collabId, @RequestBody CollabDTO collabDTO){
        collabDTO.setId(collabId);
        return posteService.updateCollab(collabDTO);
    }
    @DeleteMapping("/collabs/{id}")
    public void deletecollab(@PathVariable Long id){
        posteService.deleteCollab(id);
    }


}
