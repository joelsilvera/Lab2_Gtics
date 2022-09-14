package com.example.lab2_gtics.controller;


import com.example.lab2_gtics.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @GetMapping("/inicio")
    public String autentificacion(){
        return "inicio2";
    }
}
