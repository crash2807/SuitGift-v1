package com.project.app.services;

import com.project.app.entities.Hobby;
import com.project.app.repositories.HobbyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HobbyServiceImpl implements HobbyService {

    private HobbyRepository hobbyRepository;
    @Autowired
    public HobbyServiceImpl(HobbyRepository theHobbyRepository) {
        hobbyRepository = theHobbyRepository;
    }
    @Override
    public List<Hobby> findAll() {
        return hobbyRepository.findAllByOrderByHobbyNameAsc();
    }

    @Override
    public Hobby findById(int theId) {
        Optional<Hobby> result = hobbyRepository.findById(theId);

        Hobby theHobby = null;

        if (result.isPresent()) {
            theHobby = result.get();
        }
        else {
            throw new RuntimeException("Did not find hobby id - " + theId);
        }

        return theHobby;
    }

    @Override
    public void save(Hobby theHobby) {
        hobbyRepository.save(theHobby);
    }

    @Override
    public void deleteById(int theId) {
        hobbyRepository.deleteById(theId);
    }

    @Override
    public List<Hobby> searchBy(String theHobbyName) {
        return hobbyRepository.findByHobbyName(theHobbyName);
    }
}
