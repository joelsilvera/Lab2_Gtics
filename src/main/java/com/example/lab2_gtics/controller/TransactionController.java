package com.example.lab2_gtics.controller;

import com.example.lab2_gtics.repository.TransactionRepository;
import com.example.lab2_gtics.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    WalletRepository walletRepository;

    @GetMapping(value = {"/list"})
    public String listaTransacciones(Model model) {

        model.addAttribute("listaTransaccion", transactionRepository.findAll());
        return "transactions";
    }

}
