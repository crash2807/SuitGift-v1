
package com.project.app.repositories;

import com.project.app.entities.GiftRelationEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GiftRelationEventRepository extends JpaRepository<GiftRelationEvent,Long> {
}
