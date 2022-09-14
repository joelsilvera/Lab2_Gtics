package com.example.lab2_gtics.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/inicio")
    public String autentificacion(){
        return "inicio2";
    }
}
