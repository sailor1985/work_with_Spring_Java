package ru.goncharov.task1_new.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {


    @GetMapping("/about")
    public String about() {
        return "about.html";
    }

}
