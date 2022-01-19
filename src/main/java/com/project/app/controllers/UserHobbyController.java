package com.project.app.controllers;


import com.project.app.config.CustomUserDetails;
import com.project.app.entities.Hobby;
import com.project.app.entities.User;
import com.project.app.repositories.HobbyRepository;
import com.project.app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path="/userHobby")
public class UserHobbyController {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private HobbyRepository hobbyRepo;

    @GetMapping("/showUserHobbies")
    public String listHobbiesFromUser(Model theModel, @AuthenticationPrincipal CustomUserDetails userDetails){
        userDetails.getUserHobbies();

    return "/userHobby/list";
    }

}
