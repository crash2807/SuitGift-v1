package com.project.app.controllers;

import com.project.app.entities.Hobby;
import com.project.app.repositories.HobbyRepository;
import com.project.app.services.HobbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path="/hobbies")
public class HobbyController {

    private HobbyService hobbyService;

    public HobbyController(HobbyService theHobbyService) {
        hobbyService = theHobbyService;
    }

    @PostMapping(path = "/add")
    public @ResponseBody
    String addNewHobby(@RequestParam String name) {
        Hobby h = new Hobby();
        h.setHobbyName(name);
        hobbyService.save(h);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public String getAllHobbies(Model theModel) {
        List<Hobby> theHobbies = hobbyService.findAll();
        theModel.addAttribute("hobbies", theHobbies);
        return "hobbies/hobbies-list";
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody
    Hobby getOneHobby(@PathVariable Integer id) {
        return hobbyService.findById(id);
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        Hobby theHobby = new Hobby();

        theModel.addAttribute("hobby", theHobby);

        return "hobbies/hobby-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("idHobby") int theId,
                                    Model theModel) {

        Hobby theHobby = hobbyService.findById(theId);

        theModel.addAttribute("hobby", theHobby);

        return "hobbies/hobby-form";
    }

    @PostMapping("/save")
    public String saveHobby(
            @ModelAttribute("hobby") @Valid Hobby theHobby,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "hobbies/hobby-form";
        } else {
            hobbyService.save(theHobby);

            return "redirect:/hobbies/all";
        }
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("idHobby") int theId) {

        hobbyService.deleteById(theId);

        return "redirect:/hobbies/all";

    }

    @GetMapping("/search")
    public String search(@RequestParam("hobbyName") String theHobbyName,
                         Model theModel) {

        if (theHobbyName.trim().isEmpty()) {
            return "redirect:/employees/list";
        } else {
            List<Hobby> theHobbies =
                    hobbyService.searchBy(theHobbyName);

           theModel.addAttribute("hobbies", theHobbies);

            return "hobbies/hobbies-list";
        }
    }

}
