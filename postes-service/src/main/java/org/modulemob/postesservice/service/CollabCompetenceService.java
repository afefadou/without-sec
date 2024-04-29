package org.modulemob.postesservice.service;

import org.modulemob.postesservice.dto.CompetenceDTO;
import org.modulemob.postesservice.dto.PosteDTO;
import org.modulemob.postesservice.entities.Competence;
import org.modulemob.postesservice.entities.Poste;
import org.modulemob.postesservice.entities.PosteCompetence;
import org.modulemob.postesservice.mapper.PosteMapperImpl;
import org.modulemob.postesservice.repository.CollabRepository;
import org.modulemob.postesservice.repository.CompetenceRepository;
import org.modulemob.postesservice.repository.PosteCompetenceRepository;
import org.modulemob.postesservice.repository.PosteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PosteCompetenceService {

    @Autowired
    private CompetenceRepository competenceRepository;
    @Autowired
    private PosteRepository posteRepository;
    @Autowired
    private PosteCompetenceRepository posteCompetenceRepository;
    @Autowired
    private PosteMapperImpl dtoMapper;

    @Autowired
    public PosteCompetenceService(PosteRepository posteRepository, CompetenceRepository competenceRepository, PosteCompetenceRepository posteCompetenceRepository) {
        this.posteRepository = posteRepository;
        this.competenceRepository = competenceRepository;
        this.posteCompetenceRepository = posteCompetenceRepository;
    }



    @Transactional
    public void addCompetenceWithLevelToPoste(String posteId, String competenceId, String level) {
        // Retrieve the poste and competence entities from their respective repositories
        Poste poste = posteRepository.findById(posteId)
                .orElseThrow(() -> new IllegalArgumentException("Poste not found with id: " + posteId));

        Competence competence = competenceRepository.findById(competenceId)
                .orElseThrow(() -> new IllegalArgumentException("Competence not found with id: " + competenceId));

        // Create a new PosteCompetence entity with the provided level
        PosteCompetence posteCompetence = new PosteCompetence(poste, competence);
        posteCompetence.setLevel(level);
        posteCompetence.setRatedOn(new Date());

        // Save the new PosteCompetence entity
        posteCompetenceRepository.save(posteCompetence);
    }

//    public List<Poste> listPostes() {
//
//        List<Poste> postes = posteRepository.findAll();
//        return postes;
//
//    }

    public List<PosteDTO> listPostes() {
        List<Poste> postes = posteRepository.findAll();
        List<PosteDTO> posteDTOS = postes.stream()
                .map(poste -> dtoMapper.fromPoste(poste))
                .collect(Collectors.toList());

        return posteDTOS;
    }
}
