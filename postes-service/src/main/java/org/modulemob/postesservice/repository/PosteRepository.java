package org.modulemob.postesservice.repository;

import org.modulemob.postesservice.entities.Poste;
import org.modulemob.postesservice.entities.Poste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;



import java.util.List;
@CrossOrigin("*")

public interface PosteRepository extends JpaRepository<Poste,String> {
    @Query("select p from Poste p where p.titre like :kw")
    List<Poste> searchPoste(@Param("kw") String keyword);


}
