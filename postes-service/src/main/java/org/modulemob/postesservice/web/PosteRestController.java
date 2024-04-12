package org.modulemob.postesservice.web;

import org.modulemob.postesservice.entities.Poste;
import org.modulemob.postesservice.repository.PosteRepository;
import org.modulemob.postesservice.service.PosteService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PosteRestController {

    private PosteService posteService;
    private PosteRepository posteRepository;

    public PosteRestController(PosteRepository posteRepository) {
        this.posteRepository = posteRepository;
    }

    @GetMapping("/postes")
    public List<Poste> getAllPostes() {
        return posteRepository.findAll();
    }

    @GetMapping("/postes/{id}")
    public Poste getPosteById(@PathVariable String id) {
        return posteRepository.findById(id).orElse(null);
    }

    @PostMapping("/postes")

    public Poste createPoste(@RequestBody Poste poste) {
        return posteRepository.save(poste);
    }

    @PutMapping("/postes/{id}")

    public Poste updatePoste(@PathVariable String id, @RequestBody Poste updatedPoste) {
        Poste existingPoste = posteRepository.findById(id).orElse(null);
        if (existingPoste != null) {
            existingPoste.setTitre(updatedPoste.getTitre());
            // Update other fields as needed
            return posteRepository.save(existingPoste);
        }
        return null;
    }

    @DeleteMapping("/postes/{id}")

    public void deletePoste(@PathVariable String id) {
        posteRepository.deleteById(id);
    }

}
