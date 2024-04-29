package org.modulemob.postesservice.service;

import jakarta.persistence.EntityNotFoundException;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modulemob.postesservice.dto.CollabDTO;
import org.modulemob.postesservice.dto.CompetenceDTO;
import org.modulemob.postesservice.dto.PosteDTO;
import org.modulemob.postesservice.dto.PosteHistoryDTO;
import org.modulemob.postesservice.entities.Collab;
import org.modulemob.postesservice.entities.Competence;
import org.modulemob.postesservice.entities.Poste;
import org.modulemob.postesservice.entities.PosteCompetence;
import org.modulemob.postesservice.exceptions.CollabNotFoundException;
import org.modulemob.postesservice.exceptions.CompetenceNotFoundException;
import org.modulemob.postesservice.exceptions.PosteNotFoundException;
import org.modulemob.postesservice.mapper.PosteMapperImpl;
import org.modulemob.postesservice.repository.CollabRepository;
import org.modulemob.postesservice.repository.CompetenceRepository;
import org.modulemob.postesservice.repository.PosteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Slf4j



public class PosteServiceImpl implements PosteService {

    @Autowired
    private CompetenceRepository competenceRepository;
    @Autowired
    private PosteRepository posteRepository;
    @Autowired
    private CollabRepository collabRepository;
    @Autowired
    private PosteMapperImpl dtoMapper;

    // Constructor injection
    @Autowired
    public PosteServiceImpl(PosteRepository posteRepository, CollabRepository collabRepository,
                            CompetenceRepository competenceRepository, PosteMapperImpl posteMapper) {
        this.posteRepository = posteRepository;
        this.collabRepository = collabRepository;
        this.competenceRepository = competenceRepository;
        this.dtoMapper = posteMapper;
    }



    /************************************************
     * **********************************************
     * ************Services for competences**********
     * **********************************************
     * **********************************************/

    // Services for competences

    @Override
    public String saveCompetenceForPoste(String id_com, String id_post) {
//        Optional<Poste> optionalPoste = this.posteRepository.findById(id_post);
//        if (optionalPoste.isPresent()) {
//            Optional<Competence> optionalCompetence = this.competenceRepository.findById(id_com);
//            if (optionalCompetence.isPresent()) {
//                Poste poste = optionalPoste.get();
//                Competence competence = optionalCompetence.get();
//
//                // Set the competenceDate to the current date
//                competence.setDateDajoutCompetence(new Date());
//
//               // poste.getCompetences().add(competence); // Add the competence to the set of competences
//                this.posteRepository.save(poste);
//                return "Insertion de competence terminée";
//            }
//        }
        return "Vien Demain";
    }


    @Override
    public List<CompetenceDTO> saveCompetencesForPost(String postId, List<CompetenceDTO> competenceDTOs) {
        log.info("Saving new Competences");
        List<Competence> competences = new ArrayList<>();
        for (CompetenceDTO competenceDTO : competenceDTOs) {
            competences.add(dtoMapper.fromCompetenceDTO(competenceDTO));
        }
        List<Competence> savedCompetences = competenceRepository.saveAll(competences);
        return savedCompetences.stream()
                .map(dtoMapper::fromCompetence)
                .collect(Collectors.toList());
    }


//    @Override
//    public CompetenceDTO saveCompetenceForPoste(String postId, CompetenceDTO competenceDTO) {
//        return null;
//    }

    @Override
    public CompetenceDTO saveCompetence(CompetenceDTO competenceDTO) {
        log.info("Saving new Competence");
        Competence competence=dtoMapper.fromCompetenceDTO(competenceDTO);
        Competence savedCompetence = competenceRepository.save(competence);
        return dtoMapper.fromCompetence(savedCompetence);
    }


    @Override
    public List<CompetenceDTO> listCompetences() {
        List<Competence> competences = competenceRepository.findAll();
        List<CompetenceDTO> competenceDTOS = competences.stream()
                .map(competence -> dtoMapper.fromCompetence(competence))
                .collect(Collectors.toList());
        /*
        List<CompetenceDTO> competenceDTOS=new ArrayList<>();
        for (Competence competence:competences){
            CompetenceDTO competenceDTO=dtoMapper.fromCompetence(competence);
            competenceDTOS.add(competenceDTO);
        }
        *
         */
        return competenceDTOS;
    }

    @Override
    public CompetenceDTO updateCompetence(CompetenceDTO competenceDTO) {
        log.info("Updating Competence");
        Competence competence = dtoMapper.fromCompetenceDTO(competenceDTO);
        Competence savedCompetence = competenceRepository.save(competence);
        return dtoMapper.fromCompetence(savedCompetence);

    }

    @Override
    public void deleteCompetence(String competenceId) {
        competenceRepository.deleteById(competenceId);

    }

    @Override
    public List<CompetenceDTO> searchCompetence(String keyword) {
//        List<Competence> competences=competenceRepository.searchCompetence(keyword);
//        List<CompetenceDTO> competenceDTOS = competences.stream().map(cust -> dtoMapper.fromCompetence(cust)).collect(Collectors.toList());
        return null;
    }

    @Override
    public CompetenceDTO getCompetenceById(String competenceId) throws CompetenceNotFoundException {
        Competence competence = competenceRepository.findById(competenceId)
                .orElseThrow(() -> new CompetenceNotFoundException("Competence not found with ID: " + competenceId));

        return dtoMapper.fromCompetence(competence);
    }



    /************************************************
     * **********************************************
     * *************Services for postes**************
     * **********************************************
     * **********************************************/


    // Services for postes

    @Override
    public void addCompetenceWithLevel(String postId, String competenceId, String level) throws PosteNotFoundException, CompetenceNotFoundException {
        Optional<Poste> optionalPoste = this.posteRepository.findById(postId);
        if (optionalPoste.isPresent()) {
            Optional<Competence> optionalCompetence = this.competenceRepository.findById(competenceId);
            if (optionalCompetence.isPresent()) {
                Poste poste = optionalPoste.get();
                Competence competence = optionalCompetence.get();



                PosteCompetence posteCompetence = new PosteCompetence(poste, competence);
                // Set the competenceDate to the current date
                posteCompetence.setRatedOn(new Date());
               // poste.getPosteCompetences().add(posteCompetence);
               // competence.getPosteCompetences().add(posteCompetence);
                this.posteRepository.save(poste);
            } else {
                throw new CompetenceNotFoundException("Competence not found with ID: " + competenceId);
            }
        } else {
            throw new PosteNotFoundException("Poste not found with ID: " + postId);
        }
    }



    @Override
    // Helper method to remove competence with level
    public void removeCompetenceWithLevel(Poste poste, Competence competence) {
        Iterator<PosteCompetence> iterator = poste.getPosteCompetences().iterator();
        while (iterator.hasNext()) {
            PosteCompetence posteCompetence = iterator.next();
            if (posteCompetence.getPoste().equals(poste) && posteCompetence.getCompetence().equals(competence)) {
                iterator.remove();
                posteCompetence.getCompetence().getPosteCompetences().remove(posteCompetence);
                posteCompetence.setPoste(null);
                posteCompetence.setCompetence(null);
            }
        }
    }
    @Override
    public PosteDTO getPosteById(String posteId) throws PosteNotFoundException {
        Poste poste = posteRepository.findById(posteId)
                .orElseThrow(() -> new PosteNotFoundException("Poste not found with ID: " + posteId));

        return dtoMapper.fromPoste(poste);

    }

    @Override
    public List<Poste> listPostes() {

        List<Poste> postes = posteRepository.findAll();


        return postes;
        //return posteRepository.findAll();

    }

    @Override
    public List<PosteDTO> searchPoste(String keyword) {
        List<Poste> postes=posteRepository.searchPoste(keyword);
        List<PosteDTO> posteDTOS = postes.stream().map(cust -> dtoMapper.fromPoste(cust)).collect(Collectors.toList());
        return posteDTOS;
    }

    @Override
    public PosteDTO savePoste(PosteDTO posteDTO) {
        log.info("Saving new Poste");
        Poste poste=dtoMapper.fromPosteDTO(posteDTO);
        Poste savedPoste = posteRepository.save(poste);
        return dtoMapper.fromPoste(savedPoste);
    }



    @Override
    public PosteDTO updatePoste(PosteDTO posteDTO) {
        log.info("Updating Collab");
        Poste poste = dtoMapper.fromPosteDTO(posteDTO); // Map posteDTO to poste entity
        Poste savedPoste = posteRepository.save(poste); // Save the updated poste entity
        return dtoMapper.fromPoste(savedPoste); // Map the saved poste entity back to a posteDTO
    }

    @Override
    public void deletePoste(String posteId) {
        posteRepository.deleteById(posteId);
    }

    @Override
    public PosteHistoryDTO getPosteHistory(String posteId) throws PosteNotFoundException {
        // Implementation to get history of a poste
        return null;
    }

    @Override
    public List<CompetenceDTO> posteHistory(String posteId) {
       // List<Competence> competences = competenceRepository.findByPostes_Id(posteId);
       // return competences.stream().map(op->dtoMapper.fromCompetence(op)).collect(Collectors.toList());


        return null;
    }

    @Override
    public PosteHistoryDTO getPosteHistory(String posteId, int page, int size) throws PosteNotFoundException {
//        Poste poste=posteRepository.findById(posteId).orElse(null);
//        if(poste==null) throw new PosteNotFoundException("Poste not Found");
//        Page<Competence> posteCompetences = competenceRepository.findByPostes_IdOrderByDateDajoutCompetenceDesc(posteId, PageRequest.of(page, size));
//        //Page<Collab> posteCollabs = collabRepository.findByPosteIdOrderByCollabDateDesc(posteId, PageRequest.of(page, size));
//
//        PosteHistoryDTO posteHistoryDTO=new PosteHistoryDTO();
//
//        List<CompetenceDTO> competenceDTOS = posteCompetences.getContent().stream().map(op -> dtoMapper.fromCompetence(op)).collect(Collectors.toList());
//        //List<CollabDTO> collabDTOS = posteCollabs.getContent().stream().map(op -> dtoMapper.fromCollab(op)).collect(Collectors.toList());
//
//        posteHistoryDTO.setCompetenceDTOS(competenceDTOS);
//       // posteHistoryDTO.setCollabDTOS(collabDTOS);
//
//        posteHistoryDTO.setPosteId(poste.getId());
//        posteHistoryDTO.setCurrentPage(page);
//        posteHistoryDTO.setPageSize(size);
//        posteHistoryDTO.setTotalPages(posteCompetences.getTotalPages());
//        return posteHistoryDTO;
        return null;
    }


    /************************************************
     * **********************************************
     * *************Services for collabs**************
     * **********************************************
     * **********************************************/


    // Services for collabs

    @Override
    public CollabDTO saveCollab(CollabDTO collabDTO) {
        log.info("Saving new Collab");
        Collab collab=dtoMapper.fromCollabDTO(collabDTO);
        Collab savedCollab = collabRepository.save(collab);
        return dtoMapper.fromCollab(savedCollab);
    }


    @Override
    public CollabDTO getCollab(Long collabId) throws CollabNotFoundException {
        Collab collab = collabRepository.findById(collabId)
                .orElseThrow(() -> new CollabNotFoundException("Collab not found" + collabId));
        return dtoMapper.fromCollab(collab);
    }

    @Override
    public CollabDTO updateCollab(CollabDTO collabDTO) {
        log.info("Updating Collab");
        Collab collab = dtoMapper.fromCollabDTO(collabDTO); // Map CollabDTO to Collab entity
        Collab savedCollab = collabRepository.save(collab); // Save the updated collab entity
        return dtoMapper.fromCollab(savedCollab); // Map the saved collab entity back to a CollabDTO

    }


    @Override
    public void deleteCollab(Long collabId) {
        collabRepository.deleteById(collabId);
    }

    @Override
    public List<Collab> listeCollabs() {
        List<Collab> collabs = collabRepository.findAll();
        return collabs;
    }

//    @Override
//    public void attributeCollaboratorToPoste(String posteId, Collab collab) {
//        Poste poste = posteRepository.findById(posteId).orElseThrow(() -> new EntityNotFoundException("Post not found"));
//        poste.setCollab(collab);
//        posteRepository.save(poste);
//    }

    @Transactional


    @Override
    public void attributeCollaboratorToPoste( String posteId, Long collaboratorId) {
        Collab collab = collabRepository.findById(collaboratorId)
                .orElseThrow(() -> new EntityNotFoundException("Collaborator not found with id: " + collaboratorId));

        // Find the post or create a new one if it doesn't exist
        Poste poste = posteRepository.findById(posteId)
                .orElseThrow(() -> new EntityNotFoundException("Post not found with id: " + posteId));


        // Assign the collaborator to the post
        poste.setCollab(collab);

        // Save the updated post
        posteRepository.save(poste);
    }

    @Override
    public Page<Competence> findCompetencesByPostes(String posteId, int page, int size) {
//        Pageable pageable = PageRequest.of(page, size);
//        return competenceRepository.findByPostes(posteId, pageable);
        return null;
    }

    @Override
    public String addCollabPost(long id_col, String id_post) {
        Optional<Poste> optionalPoste = this.posteRepository.findById(id_post);
        if(optionalPoste.isPresent()){
            Optional<Collab> optionalCollab = this.collabRepository.findById(id_col);
            if(optionalCollab.isPresent()){
                Poste poste = optionalPoste.get();
                Collab collab = optionalCollab.get();
                poste.setCollab(collab);
                //collab.setPoste(poste);
                this.posteRepository.save(poste);
                this.collabRepository.save(collab);
                return "insertion terminée";
            }
        }
        return "Vien Demain";
    }

    @Override
    public List<CollabDTO> searchCollabs(String keyword) {
        List<Collab> collabs=collabRepository.searchCollab(keyword);
        List<CollabDTO> collabDTOS = collabs.stream().map(cust -> dtoMapper.fromCollab(cust)).collect(Collectors.toList());
        return collabDTOS;
    }
}
