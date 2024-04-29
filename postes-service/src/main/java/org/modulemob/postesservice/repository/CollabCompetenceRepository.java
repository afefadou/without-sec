package org.modulemob.postesservice.repository;

import org.modulemob.postesservice.embadded.PosteCompetenceId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.modulemob.postesservice.entities.PosteCompetence;

@Repository
public interface PosteCompetenceRepository extends JpaRepository<PosteCompetence, PosteCompetenceId> {
    // Add custom query methods if needed
}