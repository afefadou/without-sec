package org.modulemob.postesservice.repository;

import org.modulemob.postesservice.entities.Poste;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PosteRepository extends JpaRepository<Poste,String> {
}
