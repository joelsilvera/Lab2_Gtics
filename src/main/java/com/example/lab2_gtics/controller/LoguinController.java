package com.example.lab2_gtics.controller;

import com.example.lab2_gtics.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.lab2_gtics.Entity.User;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/login")

public class LoguinController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/loguear")
    public String envioHaciaElForm() {
        return "login/inicio2";
    }

    @PostMapping("/comprobarCredenciales")
    public String compruebaCredenciales (@RequestParam("email") String email,
                                         @RequestParam("password") String password){

        List<User> userList = userRepository.findAll();
        for(User usuario : userList){
            if(usuario.getEmail().equals(email) && usuario.getPassword().equals(password)){
                System.out.println("Logueo Exitoso");
                return "redirect:/login/accedido";
            }else{
                return "redirect:/login/loguear";
            }
        }
        return "redirect:/";
    }

    @GetMapping("/accedido")
    public String accedido() {
        return "principal";
    }

}
