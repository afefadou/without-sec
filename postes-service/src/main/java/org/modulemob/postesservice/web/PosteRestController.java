package org.modulemob.postesservice.web;

import jakarta.persistence.EntityNotFoundException;
import jakarta.ws.rs.PUT;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modulemob.postesservice.dto.CollabDTO;
import org.modulemob.postesservice.dto.CompetenceDTO;
import org.modulemob.postesservice.dto.PosteDTO;
import org.modulemob.postesservice.dto.PosteHistoryDTO;
import org.modulemob.postesservice.entities.Collab;
import org.modulemob.postesservice.entities.Competence;
import org.modulemob.postesservice.entities.Poste;
import org.modulemob.postesservice.exceptions.CompetenceNotFoundException;
import org.modulemob.postesservice.exceptions.PosteNotFoundException;
import org.modulemob.postesservice.repository.CollabRepository;
import org.modulemob.postesservice.repository.PosteRepository;
import org.modulemob.postesservice.service.PosteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class PosteRestController {

    @Autowired
    private final PosteService posteService;


    //all good

    @GetMapping("/postes")
    public List<Poste> postes() {
        return posteService.listPostes();
    }

    @PutMapping("/postes/affectCollab/{id_c}/poste/{id_p}")
    public String postColl(@PathVariable("id_c") long id_c, @PathVariable("id_p")String id_p){
        return this.posteService.addCollabPost(id_c, id_p);
    }

    @DeleteMapping("/postes/delete/{id}")
    public ResponseEntity<Void> deletePoste(@PathVariable String id) {
        posteService.deletePoste(id);
        return ResponseEntity.noContent().build();
    }


    //does not work correctly


    @GetMapping("/postes/search_postes")
    public List<PosteDTO> searchPostes(@RequestParam(name = "keyword", defaultValue = "") String keyword) {
        return posteService.searchPoste("%" + keyword + "%");
    }

    @GetMapping("/postes/voir_poste/{id}")
    public ResponseEntity<PosteDTO> getPosteById(@PathVariable(name = "id") String posteId) {
        try {
            PosteDTO posteDTO = posteService.getPosteById(posteId);
            return ResponseEntity.ok(posteDTO);
        } catch (PosteNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/postes/update/{posteId}")
    public PosteDTO updatePoste(@PathVariable String posteId, @RequestBody PosteDTO posteDTO){
        posteDTO.setId(posteId);
        return posteService.updatePoste(posteDTO);
    }

    @GetMapping("/postes/{posteId}/competences")
    public List<CompetenceDTO> getHistory(@PathVariable String posteId){
        return posteService.posteHistory(posteId);
    }




//    @PostMapping("/postes/{postId}/competences/{competenceId}")
//    public ResponseEntity<String> addCompetenceWithLevel(
//            @PathVariable String postId,
//            @PathVariable String competenceId,
//            @RequestParam String level) {
//
//        try {
//            posteService.addCompetenceWithLevel(postId, competenceId, level);
//            return ResponseEntity.ok("Competence added with level successfully.");
//        } catch (PosteNotFoundException | CompetenceNotFoundException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
//    @GetMapping("/postes/{posteId}/pageCompetences")
//    public PosteHistoryDTO getPosteHistory(
//            @PathVariable String posteId,
//            @RequestParam(name="page",defaultValue = "0") int page,
//            @RequestParam(name="size",defaultValue = "5")int size) throws PosteNotFoundException {
//        return posteService.getPosteHistory(posteId,page,size);
//    }





//    @PutMapping("/postes/affectCompetence/{id_com}/poste/{id_post}")
//    public String postCom(@PathVariable("id_com") String id_com, @PathVariable("id_post")String id_post){
//        return this.posteService.saveCompetenceForPoste(id_com, id_post);
//    }










//    @PutMapping("/postes/{posteId}")
//    public ResponseEntity<PosteDTO> updatePoste(@PathVariable String posteId, @RequestBody PosteDTO posteDTO) {
//
//        posteDTO.setId(posteId);
//        PosteDTO updatedPosteDTO = posteService.updatePoste(posteDTO);
//        return ResponseEntity.ok(updatedPosteDTO);
//    }

//    @PostMapping("/postes/save_poste")
//    public ResponseEntity<PosteDTO> savePoste(@RequestBody PosteDTO posteDTO) {
//        PosteDTO savedPosteDTO = posteService.savePoste(posteDTO);
//        return ResponseEntity.status(HttpStatus.CREATED).body(savedPosteDTO);
//    }
//

//    @GetMapping("/postes/{posteId}/history")
//    public ResponseEntity<PosteHistoryDTO > getPosteHistory(@PathVariable String posteId) {
//        try {
//            PosteHistoryDTO posteHistoryDTO = posteService.getPosteHistory(posteId);
//            return ResponseEntity.ok(posteHistoryDTO);
//        } catch (PosteNotFoundException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
//

//    @GetMapping("/postes/show")
//    public ResponseEntity<List<Poste>> getAllPostes() {
//        List<Poste> postes = new ArrayList<Poste>();
//
//        posteRepository.findAll().forEach(postes::add);
//
//        if (postes.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//
//        return new ResponseEntity<>(postes, HttpStatus.OK);
//    }




//
//    @PostMapping("/postes")
//
//    public Poste createPoste(@RequestBody Poste poste) {
//        return posteRepository.save(poste);
//    }
//
//    @PutMapping("/postes/{id}")
//
//    public Poste updatePoste(@PathVariable String id, @RequestBody Poste updatedPoste) {
//        Poste existingPoste = posteRepository.findById(id).orElse(null);
//        if (existingPoste != null) {
//            existingPoste.setTitre(updatedPoste.getTitre());
//            // Update other fields as needed
//            return posteRepository.save(existingPoste);
//        }
//        return null;
//    }
//
//    @DeleteMapping("/postes/{id}")
//
//    public void deletePoste(@PathVariable String id) {
//        posteRepository.deleteById(id);
//    }


//    @GetMapping("/competences/{posteId}/{page}/{size}")
//    public ResponseEntity<Page<Competence>> getCompetencesByPostes(@RequestParam("posteId") String posteId,
//                                                                   @RequestParam("page") int page,
//                                                                   @RequestParam("size") int size) {
//        Page<Competence> competencesPage = posteService.findCompetencesByPostes(posteId, page, size);
//        return ResponseEntity.ok(competencesPage);
//    }

}
