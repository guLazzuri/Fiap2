package com.lazzuri.CashPlus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lazzuri.CashPlus.model.Transaction;

public interface  TransactionRepository extends JpaRepository<Transaction, Long> {

    //List<Transaction> findByDescriptionContainingIgnoringCase(String description); // Query Methods

    //List<Transaction> findByDescriptionContainingIgnoringCaseAndDate(String description, LocalDate date);

   // List<Transaction> findByDate(LocalDate date);


    
}
