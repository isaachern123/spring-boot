package com.codeup.codeupspringblog.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    @ResponseBody
    public String landingPage() {
        return "this is your home page";
    }
}
