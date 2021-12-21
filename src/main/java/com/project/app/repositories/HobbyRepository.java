package com.project.app.repositories;

import com.project.app.entities.Hobby;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HobbyRepository extends JpaRepository<Hobby,Integer> {
    public List<Hobby> findAllByOrderByHobbyNameAsc();
    public List<Hobby> findByHobbyName(String hobbyName);
}
