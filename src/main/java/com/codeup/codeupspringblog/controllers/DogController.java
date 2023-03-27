package docrob.springdemo1.controllers;

import com.codeup.codeupspringblog.models.Dog;
import com.codeup.codeupspringblog.repositories.DogRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/dogs")
public class DogController {

    private final DogRepository dogDao;

    @GetMapping
    public String all(Model model) {
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog(1, "Spot"));
        dogs.add(new Dog(2, "Barfy"));

        model.addAttribute("dogs", dogs);

        return "dogs";
    }

    @GetMapping("/{dogId}")
    @ResponseBody
    public String viewDog(@PathVariable long dogId) {
        Dog dog = dogDao.findAll();
    }

    @GetMapping("/create")
    public String createDog() {
        Dog dog = new Dog();
        dog.setName("rupert");

        dogDao.save(dog);
        return "dog created";
    }


    @Override
    public String toString() {
        return super.toString();
    }
}