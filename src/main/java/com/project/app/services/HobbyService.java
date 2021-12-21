package com.project.app.services;

import com.project.app.entities.Hobby;

import java.util.List;

public interface HobbyService {

    public List<Hobby> findAll();

    public Hobby findById(int theId);

    public void save(Hobby theEmployee);

    public void deleteById(int theId);

    public List<Hobby> searchBy(String theHobbyName);


}
