package com.project.app.services;

import com.project.app.entities.User;
import com.project.app.repositories.UserRepository;
import io.vavr.control.Either;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    // private final BCryptPasswordEncoder passwordEncoder;
/*
    public UserServiceImpl(UserRepository userRepository,
                           BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }
*/
    @Autowired
    public UserServiceImpl(UserRepository theUserRepository){
        userRepository=theUserRepository;
    }

    @Override
    public User findByEmail(String email) {

        return userRepository.findByEmail(email);
    }
/*
    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
*/

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Either<Object, Optional<User>> findById(int theId) {
        Optional<User> result = userRepository.findById(theId);

        return Either.right(result);
    }

    @Override
    public void save(User theUser) {
        userRepository.save(theUser);
    }

    @Override
    public void deleteById(int theId) {
        userRepository.deleteById(theId);
    }

    @Override
    public List<User> searchBy(String theName, String theSurname) {
        return userRepository.findByNameContainsAndSurnameContainsAllIgnoreCase(theName,theSurname);
    }
}
