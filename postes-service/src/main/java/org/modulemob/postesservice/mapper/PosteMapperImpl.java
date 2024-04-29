package org.modulemob.postesservice.mapper;

import org.modulemob.postesservice.dto.CollabDTO;
import org.modulemob.postesservice.dto.CompetenceDTO;
import org.modulemob.postesservice.dto.PosteDTO;
import org.modulemob.postesservice.entities.Collab;
import org.modulemob.postesservice.entities.Competence;
import org.modulemob.postesservice.entities.Poste;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class PosteMapperImpl {
    public CompetenceDTO fromCompetence(Competence Competence){
        if (Competence == null) {
            return null;
        }
        CompetenceDTO CompetenceDTO=new CompetenceDTO();
        BeanUtils.copyProperties(Competence,CompetenceDTO);
        return  CompetenceDTO;
    }
    public Competence fromCompetenceDTO(CompetenceDTO CompetenceDTO){
        if (CompetenceDTO == null) {
            return null;
        }
        Competence Competence=new Competence();
        BeanUtils.copyProperties(CompetenceDTO,Competence);
        return  Competence;
    }

    public CollabDTO fromCollab(Collab Collab){
        if (Collab == null) {
            return null;
        }

        CollabDTO CollabDTO=new CollabDTO();
        BeanUtils.copyProperties(Collab,CollabDTO);
        return  CollabDTO;
    }
    public Collab fromCollabDTO(CollabDTO CollabDTO){
        if (CollabDTO == null) {
            return null;
        }
        Collab Collab=new Collab();
        BeanUtils.copyProperties(CollabDTO,Collab);
        return  Collab;
    }

    public PosteDTO fromPoste(Poste poste){
        if (poste == null) {
            return null;
        }
        PosteDTO PosteDTO=new PosteDTO();
        BeanUtils.copyProperties(poste,PosteDTO);
        return  PosteDTO;
    }
    public Poste fromPosteDTO(PosteDTO posteDTO){
        if (posteDTO == null) {
            return null;
        }
        Poste Poste=new Poste();
        BeanUtils.copyProperties(posteDTO,Poste);
        return Poste;
    }




}
