package com.example.lab2_gtics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")

public class LoguinController {

    @GetMapping("/loguear")
    public String loguinController (){
        return "login/inicio2";
    }


}
