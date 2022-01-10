package com.project.app.controllers;

import com.project.app.entities.Hobby;
import com.project.app.entities.User;
import com.project.app.services.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController (UserService theUserService){
        userService=theUserService;
    }

    @GetMapping("/list")
    public String listUsers(Model theModel){
        List<User> theUsers= userService.findAll();

        theModel.addAttribute("users",theUsers);

        return "users/users-list";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        User theUser = new User();

        theModel.addAttribute("user", theUser);

        return "users/user-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("idUser") int theId,
                                    Model theModel) {

        User theUser = userService.findById(theId);

        theModel.addAttribute("user", theUser);

        return "users/user-form";
    }
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());

        return "users/user-form";
    }
    @PostMapping("/process_register")
    public String saveUser(
            @ModelAttribute("user") @Valid User theUser,
            BindingResult bindingResult) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(theUser.getPassword());
        theUser.setPassword(encodedPassword);

        if (bindingResult.hasErrors()) {
            return "users/user-form";
        } else {
            userService.save(theUser);

            return "register_success";
        }
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("idUser") int theId) {

        userService.deleteById(theId);

        return "redirect:/users/list";

    }

    @GetMapping("/search")
    public String search(@RequestParam("Name") String theName,
                         @RequestParam("Surname") String theSurname,
                         Model theModel) {

        if (theName.trim().isEmpty() && theSurname.trim().isEmpty()) {
            return "redirect:/users/list";
        } else {
            List<User> theUsers =
                    userService.searchBy(theName,theSurname);

            theModel.addAttribute("users", theUsers);

            return "users/users-list";
        }
    }
}
