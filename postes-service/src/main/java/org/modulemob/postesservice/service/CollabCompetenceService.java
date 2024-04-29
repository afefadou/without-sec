package org.modulemob.postesservice.service;


import org.modulemob.postesservice.entities.Collab;
import org.modulemob.postesservice.entities.CollabCompetence;
import org.modulemob.postesservice.entities.Competence;
import org.modulemob.postesservice.mapper.PosteMapperImpl;
import org.modulemob.postesservice.repository.CollabCompetenceRepository;
import org.modulemob.postesservice.repository.CollabRepository;
import org.modulemob.postesservice.repository.CompetenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CollabCompetenceService {

    @Autowired
    private CompetenceRepository competenceRepository;
    @Autowired
    private CollabRepository collabRepository;
    @Autowired
    private CollabCompetenceRepository collabCompetenceRepository;
    @Autowired
    private PosteMapperImpl dtoMapper;

    @Autowired
    public CollabCompetenceService(CollabRepository collabRepository, CompetenceRepository competenceRepository, CollabCompetenceRepository collabCompetenceRepository) {
        this.collabRepository = collabRepository;
        this.competenceRepository = competenceRepository;
        this.collabCompetenceRepository = collabCompetenceRepository;
    }



    @Transactional
    public void addCompetenceWithLevelToCollab(Long collabId, String competenceId, String level) {
        // Retrieve the collab and competence entities from their respective repositories
        Collab collab = collabRepository.findById(collabId)
                .orElseThrow(() -> new IllegalArgumentException("collab not found with id: " + collabId));

        Competence competence = competenceRepository.findById(competenceId)
                .orElseThrow(() -> new IllegalArgumentException("Competence not found with id: " + competenceId));

        // Create a new collabCompetence entity with the provided level
        CollabCompetence collabCompetence = new CollabCompetence(collab, competence);
        collabCompetence.setLevel(level);
        collabCompetence.setRatedOn(new Date());

        // Save the new collabCompetence entity
        collabCompetenceRepository.save(collabCompetence);
    }


}
