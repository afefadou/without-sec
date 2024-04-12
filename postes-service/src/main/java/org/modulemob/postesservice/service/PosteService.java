package org.modulemob.postesservice.service;


import org.modulemob.postesservice.dto.CollabDTO;
import org.modulemob.postesservice.dto.CompetenceDTO;
import org.modulemob.postesservice.dto.PosteDTO;
import org.modulemob.postesservice.dto.PosteHistoryDTO;
import org.modulemob.postesservice.exceptions.CollabNotFoundException;
import org.modulemob.postesservice.exceptions.PosteNotFoundException;

import java.util.List;

public interface PosteService {

    //services pour les competences
    List<CompetenceDTO> saveCompetencesForPost(String postId, List<CompetenceDTO> competenceDTOs);
    CompetenceDTO saveCompetence(CompetenceDTO competenceDTO);
    CompetenceDTO getCompetence();
    List<CompetenceDTO> listCompetences();
    CompetenceDTO updateCompetence(CompetenceDTO competenceDTO);
    void deleteCompetence(String competenceId);


    //services pour les postes
    PosteDTO getPoste(String postetId) throws PosteNotFoundException;
    List<PosteDTO> listPostes();
    PosteHistoryDTO posteHistory(String posteId, int page, int size) throws PosteNotFoundException;


    //services pour les collabs
    CollabDTO getCompetenceById(String competenceId) throws CollabNotFoundException;
    CollabDTO saveCollab(CollabDTO collabDTO);
    CollabDTO getCollab(Long collabId);
    CollabDTO updateCollab(CollabDTO collabDTO);
    void deleteCollab(Long collabId);

}
