package com.example.lab2_gtics.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    @GetMapping("/inicio")
    public String listaTipos (){
        return "incio2";
    }


}
