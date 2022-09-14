package com.example.lab2_gtics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Login {
    @GetMapping("/inicio")
    public String listaTipos (){
        return "incio2";
    }
}
