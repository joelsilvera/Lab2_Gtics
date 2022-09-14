package com.example.lab2_gtics.Controller;

import com.example.lab2_gtics.repository.CurrencyRepository;
import com.example.lab2_gtics.entity.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/currency")
public class CurrencyController {
    @Autowired
    CurrencyRepository currencyRepository;

    @GetMapping("/listar")
    public String listar(Model model) {
        List<Currency> currencyList = currencyRepository.findAll();
        model.addAttribute("currencyList", currencyList);
        return "principal";
    }
}
