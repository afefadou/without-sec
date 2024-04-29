package org.modulemob.postesservice.repository;

//import org.hibernate.query.Page;
import org.modulemob.postesservice.entities.Competence;
import org.modulemob.postesservice.entities.Competence;
import org.modulemob.postesservice.entities.Poste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface CompetenceRepository extends JpaRepository<Competence,String> {
//    @Query("select c from Competence c where c.nom like :kw")
//    List<Competence> searchCompetence(@Param("kw") String keyword);


    //List<Competence> findByPostes_Id(String posteId);
    //Page<Competence> findByPostes_IdOrderByDateDajoutCompetenceDesc(String posteId, Pageable pageable);


}
