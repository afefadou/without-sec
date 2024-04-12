//package org.modulemob.postesservice.service;
//
//import jakarta.transaction.Transactional;
//import lombok.AllArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.modulemob.postesservice.dto.CollabDTO;
//import org.modulemob.postesservice.dto.CompetenceDTO;
//import org.modulemob.postesservice.dto.PosteDTO;
//import org.modulemob.postesservice.dto.PosteHistoryDTO;
//import org.modulemob.postesservice.entities.Collab;
//import org.modulemob.postesservice.entities.Competence;
//import org.modulemob.postesservice.entities.Poste;
//import org.modulemob.postesservice.exceptions.CollabNotFoundException;
//import org.modulemob.postesservice.exceptions.PosteNotFoundException;
//import org.modulemob.postesservice.mapper.PosteMapperImpl;
//import org.modulemob.postesservice.repository.CollabRepository;
//import org.modulemob.postesservice.repository.CompetenceRepository;
//import org.modulemob.postesservice.repository.PosteRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//@Transactional
//
//@Slf4j
//
//
//
//public class PosteServiceImpl implements PosteService {
//
//    private CompetenceRepository competenceRepository;
//    private PosteRepository posteRepository;
//    private CollabRepository collabRepository;
//    private PosteMapperImpl dtoMapper;
//
//    // Constructor injection
//    public PosteServiceImpl(CompetenceRepository competenceRepository, PosteRepository posteRepository, CollabRepository collabRepository) {
//        this.competenceRepository = competenceRepository;
//        this.posteRepository = posteRepository;
//        this.collabRepository = collabRepository;
//    }
//
//    // Services for competences
//
//    @Override
//    public List<CompetenceDTO> saveCompetencesForPost(String postId, List<CompetenceDTO> competenceDTOs) {
//        log.info("Saving new Competences");
//        List<Competence> competences = new ArrayList<>();
//        for (CompetenceDTO competenceDTO : competenceDTOs) {
//            competences.add(dtoMapper.fromCompetenceDTO(competenceDTO));
//        }
//        List<Competence> savedCompetences = competenceRepository.saveAll(competences);
//        return savedCompetences.stream()
//                .map(dtoMapper::fromCompetence)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public CompetenceDTO saveCompetence(CompetenceDTO competenceDTO) {
//        log.info("Saving new Competence");
//        Competence competence=dtoMapper.fromCompetenceDTO(competenceDTO);
//        Competence savedCompetence = competenceRepository.save(competence);
//        return dtoMapper.fromCompetence(savedCompetence);
//    }
//
//    @Override
//    public CompetenceDTO getCompetence() {
//        // Implementation to get a competence
//        return null;
//    }
//
//    @Override
//    public List<CompetenceDTO> listCompetences() {
//        // Implementation to list all competences
//        return null;
//    }
//
//    @Override
//    public CompetenceDTO updateCompetence(CompetenceDTO competenceDTO) {
//        // Implementation to update a competence
//        return null;
//    }
//
//    @Override
//    public void deleteCompetence(String competenceId) {
//        // Implementation to delete a competence
//
//    }
//
//    // Services for postes
//    @Override
//    public PosteDTO getPoste(String posteId) throws PosteNotFoundException {
//        Poste poste = posteRepository.findById(posteId)
//                .orElseThrow(() -> new PosteNotFoundException("Poste not found with ID: " + posteId));
//
//        return dtoMapper.fromPoste(poste);
//    }
//
//    @Override
//    public List<PosteDTO> listPostes() {
//        List<Poste> postes = posteRepository.findAll();
//        return postes.stream()
//                .map(dtoMapper::fromPoste)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public PosteHistoryDTO posteHistory(String posteId, int page, int size) throws PosteNotFoundException {
//        // Implementation to get history of a poste
//        return null;
//    }
//
//    // Services for collabs
//    @Override
//    public CollabDTO getCompetenceById(String competenceId) throws CollabNotFoundException {
//        // Implementation to get a collab by competence ID
//        return null;
//    }
//
//    @Override
//    public CollabDTO saveCollab(CollabDTO collabDTO) {
//        log.info("Saving new Collab");
//        Collab collab=dtoMapper.fromCollabDTO(collabDTO);
//        Collab savedCollab = collabRepository.save(collab);
//        return dtoMapper.fromCompetence(savedCollab);
//    }
//
//    @Override
//    public CollabDTO getCollab(Long collabId) throws CollabNotFoundException {
//        Collab collab = collabRepository.findById(collabId)
//                .orElseThrow(() -> new CollabNotFoundException("Collab not found"));
//        return dtoMapper.fromCollab(collab);
//    }
//
//    @Override
//    public CollabDTO updateCollab(CollabDTO collabDTO) {
//        // Implementation to update a collab
//        return null;
//    }
//
//    @Override
//    public void deleteCollab(Long collabId) {
//        // Implementation to delete a collab
//    }
//}
