package com.project.app.services;

import com.project.app.entities.User;

import java.util.List;


public interface UserService {

        User findByEmail(String email);
        List<User> findAll();
        User findById(int theId);
        void save(User theUser);
        void deleteById(int theId);
        List<User> searchBy(String theName, String theSurname);
}
