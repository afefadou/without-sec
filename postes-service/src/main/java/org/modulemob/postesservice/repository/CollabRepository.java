package org.modulemob.postesservice.repository;

import org.modulemob.postesservice.entities.Collab;
import org.modulemob.postesservice.entities.Competence;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CollabRepository extends JpaRepository<Collab, Long> {
    @Query("select c from Collab c where c.nom like :kw")
    List<Collab> searchCollab(@Param("kw") String keyword);

    //List<Collab> findByPosteId(String posteId);
    //Page<Collab> findByPosteIdOrderByCollabDateDesc(String posteId, Pageable pageable);


}
