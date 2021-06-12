package com.project.app.services;

import com.project.app.entities.User;

import java.util.List;


public interface UserService {

        User findByEmail(String email);
        void saveUser(User user);
        List<User> findAll();



}
