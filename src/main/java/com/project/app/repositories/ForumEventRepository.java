package com.project.app.repositories;

import com.project.app.entities.ForumEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForumEventRepository extends JpaRepository<ForumEvent,Integer> {
}
