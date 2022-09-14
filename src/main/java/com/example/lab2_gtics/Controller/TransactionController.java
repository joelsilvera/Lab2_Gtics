package com.example.lab2_gtics.Controller;

import com.example.lab2_gtics.Entity.Transaction;
import com.example.lab2_gtics.Repository.TransactionRepository;
import com.example.lab2_gtics.Repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    WalletRepository walletRepository;

    @GetMapping(value = {"/list", ""})
    public String listaTransacciones(Model model) {

        model.addAttribute("listaTransaccion", transactionRepository.findAll());
        return "transactions";
    }
    @PostMapping("/BuscarTransaction")
    public String buscarTransaction(@RequestParam("searchField") String searchField,
                                    Model model){

        List<Transaction> listaTransaction = transactionRepository.buscarTransPorCompName(searchField);
        model.addAttribute("listaTransaccion", listaTransaction);

        return "transactions";
    }


}
