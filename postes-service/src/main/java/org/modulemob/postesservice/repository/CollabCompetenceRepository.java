package org.modulemob.postesservice.repository;

import org.modulemob.postesservice.embadded.CollabCompetenceId;
import org.modulemob.postesservice.embadded.PosteCompetenceId;
import org.modulemob.postesservice.entities.CollabCompetence;
import org.modulemob.postesservice.entities.PosteCompetence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollabCompetenceRepository extends JpaRepository<CollabCompetence, CollabCompetenceId> {
    // Add custom query methods if needed
}