package com.project.app.repositories;

import com.project.app.entities.EventRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRelationRepository extends JpaRepository<EventRelation,Long> {
}
