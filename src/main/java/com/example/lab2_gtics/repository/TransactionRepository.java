package com.example.lab2_gtics.repository;

import com.example.lab2_gtics.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {

    @Query(value = "select * from transaction where idtransaction = ?1",
            nativeQuery = true)
    List<Transaction> buscarTransPorCompName(String nombre);
}
