package com.example.lab2_gtics.Repository;
import  com.example.lab2_gtics.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CurrencyRepository extends JpaRepository<Currency,Integer> {

    @Query(nativeQuery = true,
            value = "SELECT name, abreviation, network, description, price, abreviation FROM currency")
    List<Currency> pregunta1(String name);
}
