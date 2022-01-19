package com.project.app.services;

import com.project.app.entities.User;
import io.vavr.control.Either;

import java.util.List;
import java.util.Optional;


public interface UserService {

        User findByEmail(String email);
        List<User> findAll();
        Either<Object, Optional<User>> findById(int theId);
        void save(User theUser);
        void deleteById(int theId);
        List<User> searchBy(String theName, String theSurname);
}
