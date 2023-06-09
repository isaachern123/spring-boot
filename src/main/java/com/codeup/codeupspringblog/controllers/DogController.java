package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Dog;
import com.codeup.codeupspringblog.repositories.DogRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;


@AllArgsConstructor
@Controller
@RequestMapping(path = "/dogs")
public class DogController {

    private final DogRepository dogDao;

    @GetMapping
    public String all(Model model) {

        List<Dog> dogs = dogDao.findAll();
//

        model.addAttribute("dogs", dogs);


        return "dogs";
    }

    @GetMapping("/{dogId}")
    @ResponseBody
    public String viewDog(@PathVariable long dogId) {
        Dog dog = dogDao.findById(dogId).get();

        String newName = dog.getName() + dog.getName();
        dog.setName(newName);

        dogDao.save(dog);

        System.out.println(dog);

        return "show page for a dog w id " + dogId;
    }

    @GetMapping("/create")
    @ResponseBody
    public String createDog() {
        Dog dog = new Dog();
        dog.setName("rupert");
        dog.setGender("Male");

        dogDao.save(dog);
        return "dog created";
    }


    @Override
    public String toString() {
        return super.toString();
    }
}