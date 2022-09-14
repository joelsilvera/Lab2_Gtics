package com.example.lab2_gtics.repository;

import com.example.lab2_gtics.entity.Transaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository {
    @Query(value = "SELECT idtransaction, amount,network_fee,block, currency, wallet_idwallet  FROM dbl3.transaction;",
            nativeQuery = true)
    List<Transaction> listaTodasTransaacciones(String nombre);
}
