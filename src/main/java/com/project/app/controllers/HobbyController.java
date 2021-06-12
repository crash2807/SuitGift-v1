package com.project.app.controllers;

import com.project.app.entities.Hobby;
import com.project.app.repositories.HobbyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="/hobby")
public class HobbyController {
    @Autowired
    private HobbyRepository hobbyRepository;
    @PostMapping(path="/add")
    public @ResponseBody String addNewHobby (@RequestParam String name){
        Hobby h= new Hobby();
        h.setHobbyName(name);
        hobbyRepository.save(h);
        return "Saved";
    }
    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Hobby> getAllHobbies(){
        return hobbyRepository.findAll();
    }
    @GetMapping(path= "/{id}")
    public @ResponseBody
    Optional<Hobby> getOneHobby(@PathVariable Long id){
        return hobbyRepository.findById(id);
    }
}
