package com.example.lab2_gtics.Controller;

import com.example.lab2_gtics.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.lab2_gtics.entity.User;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/login")

public class LoguinController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/loguear")
    public String envioHaciaElForm() {
        return "inicio2";
    }

    @PostMapping("/comprobarCredenciales")
    public String compruebaCredenciales (@RequestParam("email") String email,
                                         @RequestParam("password") String password){

        List<User> userList = userRepository.findAll();
        for(User usuario : userList){
            if(usuario.getEmail().equals(email) && usuario.getPassword().equals(password)){
                return "redirect:/currency/listar";
            }else{
                return "redirect:/login/loguear";
            }
        }
        return "redirect:/";
    }

}
