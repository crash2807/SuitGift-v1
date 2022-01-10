package com.project.app.repositories;


import com.project.app.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByEmail(String email);
    List<User> findAllByOrderByNameAsc();
    List<User> findByNameContainsAndSurnameContainsAllIgnoreCase(String Name, String Surname);
}
