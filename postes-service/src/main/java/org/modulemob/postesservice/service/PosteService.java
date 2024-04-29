package org.modulemob.postesservice.service;


import org.modulemob.postesservice.dto.CollabDTO;
import org.modulemob.postesservice.dto.CompetenceDTO;
import org.modulemob.postesservice.dto.PosteDTO;
import org.modulemob.postesservice.dto.PosteHistoryDTO;
import org.modulemob.postesservice.entities.Collab;
import org.modulemob.postesservice.entities.Competence;
import org.modulemob.postesservice.entities.Poste;
import org.modulemob.postesservice.exceptions.CollabNotFoundException;
import org.modulemob.postesservice.exceptions.CompetenceNotFoundException;
import org.modulemob.postesservice.exceptions.PosteNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface PosteService {

    //services pour les competences
    CompetenceDTO getCompetenceById(String competenceId) throws CompetenceNotFoundException;
    List<CompetenceDTO> saveCompetencesForPost(String postId, List<CompetenceDTO> competenceDTOs);
    CompetenceDTO saveCompetence(CompetenceDTO competenceDTO);
    String saveCompetenceForPoste(String id_com, String id_post);
    //CompetenceDTO saveCompetenceForPoste(String postId, CompetenceDTO competenceDTO);
    List<CompetenceDTO> listCompetences();
    CompetenceDTO updateCompetence(CompetenceDTO competenceDTO);
    void deleteCompetence(String competenceId);
    List<CompetenceDTO> searchCompetence(String keyword);


    // Services for postes

    // Helper method to add competence with level
    void addCompetenceWithLevel(String postId, String comId, String level) throws PosteNotFoundException, CompetenceNotFoundException;

    // Helper method to remove competence with level
    void removeCompetenceWithLevel(Poste poste, Competence competence);

    //services pour les postes
    PosteDTO getPosteById(String postetId) throws PosteNotFoundException;
    List<Poste> listPostes();
    List<PosteDTO> searchPoste(String keyword);
    PosteDTO savePoste(PosteDTO posteDTO);
    PosteDTO updatePoste(PosteDTO posteDTO);
    void deletePoste(String posteId);
    @Transactional
    void attributeCollaboratorToPoste( String posteId,Long collabId);

    public Page<Competence> findCompetencesByPostes(String posteId, int page, int size);

    public String addCollabPost(long id_col, String id_post);

    PosteHistoryDTO getPosteHistory(String posteId) throws PosteNotFoundException;


    List<CompetenceDTO> posteHistory(String posteId);

    PosteHistoryDTO getPosteHistory(String posteId, int page, int size) throws PosteNotFoundException;

    //services pour les collabs
    CollabDTO saveCollab(CollabDTO collabDTO);
    CollabDTO getCollab(Long collabId) throws CollabNotFoundException;
    CollabDTO updateCollab(CollabDTO collabDTO);
    void deleteCollab(Long collabId);
    List<Collab> listeCollabs();
    List<CollabDTO> searchCollabs(String keyword);



}
